package org.shuize.blogmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
public class BlogManageProvider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(BlogManageProvider8001Application.class,args);
    }
}