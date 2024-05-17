package com.hana.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@OpenAPIDefinition(info = @Info(title = "Project Test", description = "Open API Test",version = "1.0"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {



    @Bean
    public OpenAPI openAPI(){
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
                .security(Arrays.asList(securityRequirement));
    }

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = { "/api//login/**" }; // 해당 path인경우에만 스웨거에 추가되도록 설정

        return GroupedOpenApi
                .builder()
                .group("login API v1")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(
                        openApi -> openApi.setInfo(
                                new Info()
                                        .title("login") // API 제목
                                        .description("Login API") // API 설명
                                        .version("1.0.0") // API 버전
                        )
                )
                .build();
    }
    @Bean
    public GroupedOpenApi chatOpenApi2() {
        String[] paths = { "/api//v1/**" }; // 해당 path인경우에만 스웨거에 추가되도록 설정

        return GroupedOpenApi
                .builder()
                .group("Pro API v1")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(
                        openApi -> openApi.setInfo(
                                new Info()
                                        .title("My Open API Project") // API 제목
                                        .description("업무 처리를 위한 API") // API 설명
                                        .version("1.0.1") // API 버전
                        )
                )
                .build();
    }
}
