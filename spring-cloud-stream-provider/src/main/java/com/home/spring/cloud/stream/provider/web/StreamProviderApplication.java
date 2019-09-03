package com.home.spring.cloud.stream.provider.web;

import com.home.spring.cloud.stream.provider.stream.MessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 18:38 2019/9/2
 * @modified by:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableBinding(value= MessageSource.class)
public class StreamProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class, args);
    }
}
