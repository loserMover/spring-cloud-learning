package com.home.spring.cloud.user.service.web.controller;

import com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.domain.User;
import com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/user/save")
    public Boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
