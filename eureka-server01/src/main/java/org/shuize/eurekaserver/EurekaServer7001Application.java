package org.shuize.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.swing.*;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7001Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Application.class, args);
    }
}