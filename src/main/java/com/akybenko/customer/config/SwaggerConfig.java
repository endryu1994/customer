package com.akybenko.customer.config;

import static com.akybenko.customer.constant.SwaggerConstants.BASE_PACKAGE;
import static com.akybenko.customer.constant.SwaggerConstants.CONTACT_EMAIL;
import static com.akybenko.customer.constant.SwaggerConstants.CONTACT_NAME;
import static com.akybenko.customer.constant.SwaggerConstants.CONTACT_URL;
import static com.akybenko.customer.constant.SwaggerConstants.DESCRIPTION;
import static com.akybenko.customer.constant.SwaggerConstants.TITLE;
import static com.akybenko.customer.constant.SwaggerConstants.VERSION;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL))
                .build();
    }
}
