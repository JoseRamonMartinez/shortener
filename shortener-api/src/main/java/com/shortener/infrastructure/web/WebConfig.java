package com.shortener.infrastructure.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CorsProperties corsProperties;

    public WebConfig(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all paths (you can restrict it to specific paths if needed)
                .allowedOrigins(corsProperties.getAllowedOrigins())  // Your Angular frontend URL
                .allowedMethods(corsProperties.getAllowedMethods())  // Allow these HTTP methods
                .allowedHeaders(corsProperties.getAllowedHeaders())  // Allow all headers
                .allowCredentials(corsProperties.isAllowCredentials());
    }
}
