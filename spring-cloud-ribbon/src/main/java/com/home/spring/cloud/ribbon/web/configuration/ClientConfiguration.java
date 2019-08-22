package com.home.spring.cloud.ribbon.web.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    /**
     * 声明RestTemplate
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate  restTemplate(){
        return new RestTemplate();
    }

}
