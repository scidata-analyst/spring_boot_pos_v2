package com.example.pos.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI (Swagger) configuration class.
 * Provides API documentation metadata for POS application.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("POS System API")
                        .description("REST API documentation for Point of Sale (POS) application")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("POS Support Team")
                                .email("support@pos.com")
                                .url("https://pos.com"))
                        .license(new License()
                                .name("Private License")
                                .url("https://pos.com/license")));
    }
}