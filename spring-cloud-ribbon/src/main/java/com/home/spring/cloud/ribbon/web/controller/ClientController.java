package com.home.spring.cloud.ribbon.web.controller;

import com.home.spring.cloud.ribbon.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Value("${service.provider.name}")
    private String serviceProviderName;


    @GetMapping("/index")
    public String index(User user){
        return restTemplate.postForObject("http://"+serviceProviderName+"/greeting",user,String.class);
    }
}
