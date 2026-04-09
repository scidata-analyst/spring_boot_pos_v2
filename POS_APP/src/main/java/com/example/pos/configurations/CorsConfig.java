package com.example.pos.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global CORS configuration.
 * <p>
 * Defines cross-origin resource sharing rules for the application.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(""*"")
                .allowedMethods(""GET"", ""POST"", ""PUT"", ""DELETE"", ""OPTIONS"")
                .allowedHeaders(""*"")
                .allowCredentials(true);
    }
}
