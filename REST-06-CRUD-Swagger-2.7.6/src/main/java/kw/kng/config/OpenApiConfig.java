package kw.kng.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() 
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Your API Title")
                        .version("1.0")
                        .description("Your API Description"));
    }

    @Bean
    public GroupedOpenApi publicApi() 
    {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }
}