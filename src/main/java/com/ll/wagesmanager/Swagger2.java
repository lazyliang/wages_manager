package com.ll.wagesmanager;

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

/**
 * Created by liliang on 2018/3/3.
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("test")
                .description("lazyliang的测试")
                        .termsOfServiceUrl("http://www.google.com.hk")
                        .contact(new Contact("lazyliang","","1015492734@qq.com"))
                        .version("1.0.0")
                        .build();
                        return new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.ll.wagesmanager"))
                        .paths(PathSelectors.any())
                        .build();
                        }
                        }
