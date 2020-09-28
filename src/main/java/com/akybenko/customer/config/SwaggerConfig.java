package com.akybenko.customer.config;

import static com.akybenko.customer.constant.SwaggerConstants.AUTHORIZATION_DESCRIPTION;
import static com.akybenko.customer.constant.SwaggerConstants.AUTHORIZATION_SCOPE;
import static com.akybenko.customer.constant.SwaggerConstants.BASE_PACKAGE;
import static com.akybenko.customer.constant.SwaggerConstants.CONTACT_EMAIL;
import static com.akybenko.customer.constant.SwaggerConstants.CONTACT_NAME;
import static com.akybenko.customer.constant.SwaggerConstants.CONTACT_URL;
import static com.akybenko.customer.constant.SwaggerConstants.DESCRIPTION;
import static com.akybenko.customer.constant.SwaggerConstants.HEADER;
import static com.akybenko.customer.constant.SwaggerConstants.TITLE;
import static com.akybenko.customer.constant.SwaggerConstants.VERSION;
import static org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory.AUTHORIZATION_HEADER;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
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
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER, HEADER);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope(AUTHORIZATION_SCOPE, AUTHORIZATION_DESCRIPTION);
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference(AUTHORIZATION_HEADER, authorizationScopes));
    }
}
