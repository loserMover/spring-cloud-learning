package com.home.spring.cloud.user.service.provider.web.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

public class UserConsumerHystrixCommand extends HystrixCommand<Collection> {
    private final String userServiceProviderName;

    private final RestTemplate restTemplate;

    public UserConsumerHystrixCommand(String userServiceProviderName, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("spring-cloud-user-service-consumer"),100);
        this.userServiceProviderName = userServiceProviderName;
        this.restTemplate = restTemplate;
    }

    @Override
    protected Collection run() throws Exception {
        return restTemplate.getForObject("http://"+userServiceProviderName+"/user/findAll", Collection.class);
    }

    @Override
    protected Collection getFallback() {
        return Collections.emptyList();
    }
}
