package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.TimeZone;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@ConfigurationPropertiesScan
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        var app = new SpringApplication(Application.class);
        app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setReadTimeout(Duration.ofSeconds(10));
        restTemplate.setConnectTimeout(Duration.ofSeconds(5));
        return restTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.info("Microservicio iniciado correctamente");
        logger.info("Perfil activo: {}", System.getProperty("spring.profiles.active", "default"));
    }

    @PreDestroy
    public void onShutdown() {
        logger.info("Microservicio detenido");
    }
}