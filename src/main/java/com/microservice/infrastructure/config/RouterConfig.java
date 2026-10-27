package com.microservice.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RouterConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RouterConfig.class);

    @Value("${app.api.prefix:api}")
    private String apiPrefix;

    @Value("${app.api.version:v1}")
    private String apiVersion;

    @Value("${app.cors.allowed-origins:*}")
    private String allowedOrigins;

    @Value("${app.cors.allowed-methods:GET,POST,PUT,DELETE,OPTIONS}")
    private String allowedMethods;

    @Value("${app.cors.max-age:3600}")
    private long corsMaxAge;

    @Value("${app.routing.case-sensitive:false}")
    private boolean caseSensitive;

    @Value("${app.routing.trailing-slash:false}")
    private boolean trailingSlash;

    private Map<String, String> routeMappings;

    @PostConstruct
    public void init() {
        routeMappings = new HashMap<>();
        routeMappings.put("/client-requests", "/api/" + apiVersion + "/client-requests");
        routeMappings.put("/health", "/actuator/health");
        routeMappings.put("/metrics", "/actuator/metrics");
        logger.info("RouterConfig initialized with prefix: {} and version: {}", apiPrefix, apiVersion);
        logger.info("Route mappings: {}", routeMappings);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(trailingSlash);
        configurer.setUseCaseSensitiveMatch(caseSensitive);
        logger.debug("Path match configured - caseSensitive: {}, trailingSlash: {}", caseSensitive, trailingSlash);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = allowedOrigins.split(",");
        String[] methods = allowedMethods.split(",");
        
        registry.addMapping("/**")
            .allowedOrigins(origins)
            .allowedMethods(methods)
            .allowedHeaders("*")
            .allowCredentials(false)
            .maxAge(corsMaxAge);
        
        logger.info("CORS configured with allowed origins: {} and methods: {}", allowedOrigins, allowedMethods);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("Interceptors registered in RouterConfig");
    }

    public String getApiPrefix() {
        return apiPrefix;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getFullApiPath() {
        return "/" + apiPrefix + "/" + apiVersion;
    }

    public Map<String, String> getRouteMappings() {
        return new HashMap<>(routeMappings);
    }

    public String resolveRoute(String path) {
        return routeMappings.getOrDefault(path, getFullApiPath() + path);
    }

    public boolean isRouteEnabled(String path) {
        return routeMappings.containsKey(path);
    }
}