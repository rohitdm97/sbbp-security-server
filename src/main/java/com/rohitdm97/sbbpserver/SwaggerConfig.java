package com.rohitdm97.sbbpserver;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(apiContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(SbbpServerApplication.class.getPackage().getName()))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "SbbpServerApplication",
                "",
                "v1",
                null,
                null,
                null,
                null,
                Collections.emptyList()
        );
    }

    private ApiKey apiKey() {
        return new ApiKey("Access Token", "access_token", "header");
    }

    private SecurityContext apiContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(
                        new SecurityReference("Access Token", new AuthorizationScope[]{
                                new AuthorizationScope("global", "Global Scope")
                        })
                ))
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

}
