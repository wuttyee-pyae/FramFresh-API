package com.java.farmfresh.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Set the allowed origin domains or use "*" for all
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Set the allowed HTTP methods
                .allowedHeaders("*") // Set the allowed headers
                .allowCredentials(false) // Allow sending cookies from the client
                .maxAge(3600); // Set the max age of the pre-flight request in seconds
    }
}

