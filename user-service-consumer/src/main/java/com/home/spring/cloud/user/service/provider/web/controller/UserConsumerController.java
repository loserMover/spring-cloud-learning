package com.home.spring.cloud.user.service.provider.web.controller;


import com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.domain.User;
import com.home.spring.cloud.user.service.provider.web.hystrix.UserConsumerHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@RestController
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.provider.name}")
    private String userServiceProviderName;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://"+userServiceProviderName+"/user/"+id,User.class);
    }

    @GetMapping("/user/findAll")
    public Collection<User> findAll() {
        UserConsumerHystrixCommand command = new UserConsumerHystrixCommand(userServiceProviderName,restTemplate);
        return command.execute();
        //  return restTemplate.getForObject("http://"+userServiceProviderName+"/user/findAll", Collection.class);
    }

    @PostMapping("/user/save")
    public Boolean saveUser(@RequestBody User user) {
        return restTemplate.postForObject("http://"+userServiceProviderName+"/user/save", user, Boolean.class);
    }

}
