package com.example.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/6 10:37
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("RabbitMQ测试")
                .description("RabbitMQ学习")
                .version("1.0")
                .contact(new Contact("yunshuaiwei", "http://ysw.com", "yunshuaiwei@163.com"))
                .build();
    }
}
