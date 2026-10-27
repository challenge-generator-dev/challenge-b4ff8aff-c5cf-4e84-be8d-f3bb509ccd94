package com.microservice.infrastructure.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {

    private static final String REQUEST_ID = "requestId";
    private static final String USER_ID = "userId";
    private static final String CLASS_NAME = "className";
    private static final String METHOD_NAME = "methodName";
    private static final String EXECUTION_TIME = "executionTime";

    @Pointcut("execution(* com.microservice.application.usecase..*(..)) || " +
              "execution(* com.microservice.infrastructure.web.controller..*(..)) || " +
              "execution(* com.microservice.domain.ports.in..*(..)))")
    public void applicationLayerMethods() {}

    @Around("applicationLayerMethods()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();

        String requestId = MDC.get(REQUEST_ID);
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
            MDC.put(REQUEST_ID, requestId);
        }

        MDC.put(CLASS_NAME, className);
        MDC.put(METHOD_NAME, methodName);

        Logger logger = getLogger(signature.getDeclaringType());

        logMethodEntry(logger, className, methodName, args);

        long startTime = System.currentTimeMillis();
        Object result = null;
        Throwable thrown = null;

        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable t) {
            thrown = t;
            throw t;
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            MDC.put(EXECUTION_TIME, String.valueOf(executionTime));

            if (thrown != null) {
                logMethodException(logger, className, methodName, thrown, executionTime);
            } else {
                logMethodExit(logger, className, methodName, result, executionTime);
            }

            MDC.remove(CLASS_NAME);
            MDC.remove(METHOD_NAME);
            MDC.remove(EXECUTION_TIME);

            if (MDC.get(REQUEST_ID) != null && MDC.get(REQUEST_ID).equals(requestId)) {
                if (!isNestedCall()) {
                    MDC.remove(REQUEST_ID);
                }
            }
        }
    }

    private void logMethodEntry(Logger logger, String className, String methodName, Object[] args) {
        if (logger.isDebugEnabled()) {
            String argsString = sanitizeArgs(args);
            logger.debug("Entering method: {}.{}() | Args: [{}]", className, methodName, argsString);
        } else {
            logger.info("Entering method: {}.{}()", className, methodName);
        }
    }

    private void logMethodExit(Logger logger, String className, String methodName, 
                                Object result, long executionTime) {
        if (logger.isDebugEnabled()) {
            String resultString = sanitizeResult(result);
            logger.debug("Exiting method: {}.{}() | Result: {} | Time: {}ms", 
                        className, methodName, resultString, executionTime);
        } else {
            logger.info("Exiting method: {}.{}() | Time: {}ms", className, methodName, executionTime);
        }
    }

    private void logMethodException(Logger logger, String className, String methodName, 
                                     Throwable thrown, long executionTime) {
        logger.error("Exception in method: {}.{}() | Exception: {} | Message: {} | Time: {}ms",
                    className, methodName, thrown.getClass().getSimpleName(), 
                    thrown.getMessage(), executionTime, thrown);
    }

    private String sanitizeArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        return Arrays.stream(args)
                .map(this::sanitizeObject)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    private String sanitizeResult(Object result) {
        if (result == null) {
            return "null";
        }
        return sanitizeObject(result);
    }

    private String sanitizeObject(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof byte[] || obj instanceof Byte[]) {
            return "[binary data]";
        }
        if (obj instanceof char[] || obj instanceof Character[]) {
            return "[char data]";
        }
        String str = obj.toString();
        if (str.length() > 200) {
            return str.substring(0, 200) + "...[truncated]";
        }
        return str;
    }

    private Logger getLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }

    private boolean isNestedCall() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int applicationLayerCount = 0;
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.contains("com.microservice.application") || 
                className.contains("com.microservice.infrastructure.web") ||
                className.contains("com.microservice.domain")) {
                applicationLayerCount++;
            }
        }
        return applicationLayerCount > 1;
    }

    public static void setUserId(String userId) {
        if (userId != null && !userId.isEmpty()) {
            MDC.put(USER_ID, userId);
        }
    }

    public static void clearUserId() {
        MDC.remove(USER_ID);
    }

    public static String getRequestId() {
        return MDC.get(REQUEST_ID);
    }

    public static String getUserId() {
        return MDC.get(USER_ID);
    }
}