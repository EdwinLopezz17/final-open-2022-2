package com.ecodriver.platform.u20201b772.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    public OpenAPI customOpenApi(
            String applicationDescription,
            String applicationVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Theraphy API")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .termsOfService("https://digitalholics-3-0.github.io/Front-End-Theraphy/tos")
                        .license(new License().name("Apache 2.0 License")
                                .url("https://digitalholics-3-0.github.io/Front-End-Theraphy/license"))
                        .contact(new Contact()
                                .url("https://digitalholics-3-0.github.io/Front-End-Theraphy.studio")
                                .name("Theraphy.studio")));
    }
}