package com.home.spring.cloud.stream.consumer.web.controller;

import com.home.spring.cloud.stream.consumer.web.domain.User;
import com.home.spring.cloud.stream.consumer.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Collection<User>  getUsers(){
        return userService.findAll();
    }
}
