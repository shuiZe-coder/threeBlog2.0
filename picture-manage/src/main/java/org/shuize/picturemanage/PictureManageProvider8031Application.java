package org.shuize.picturemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class PictureManageProvider8031Application {
    public static void main(String[] args) {
        SpringApplication.run(PictureManageProvider8031Application.class, args);
    }
}