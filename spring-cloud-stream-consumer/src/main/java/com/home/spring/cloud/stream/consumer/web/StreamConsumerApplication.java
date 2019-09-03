package com.home.spring.cloud.stream.consumer.web;

import com.home.spring.cloud.stream.consumer.stream.MessageSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 16:14 2019/9/3
 * @modified by:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableBinding(value= MessageSink.class)
public class StreamConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class, args);
    }
}
