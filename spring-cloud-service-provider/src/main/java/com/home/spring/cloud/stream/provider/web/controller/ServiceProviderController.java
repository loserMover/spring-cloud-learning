package com.home.spring.cloud.stream.provider.web.controller;


import com.home.spring.cloud.stream.provider.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

    @PostMapping("/greeting")
    public String greeting(@RequestBody User user) {
        return "Greeting , " + user;
    }

}
