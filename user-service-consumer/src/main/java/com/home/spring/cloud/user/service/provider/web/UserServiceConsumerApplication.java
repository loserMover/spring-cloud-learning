package com.home.spring.cloud.user.service.provider.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient("spring-cloud-user-service-provider")
public class UserServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumerApplication.class, args);
    }
}
