package com.init.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j 配置
 * 作者网站：<a href="https://doc.xiaominfo.com/docs/quick-start#spring-boot-3">...</a>
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI restfulOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("随心")
                        .description("Spring Boot3 Restful API")
                        .version("V1.0.0")
                        .license(new License().name("访问 SpringDoc 官方网站").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("欢迎访问随心记")
                        .url("https://doc.xiaominfo.com/docs/quick-start#spring-boot-3"));
    }

}