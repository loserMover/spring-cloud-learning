package com.home.spring.cloud.user.service.provider.web.controller;


import com.home.spring.cloud.user.service.api.web.domain.User;
import com.home.spring.cloud.user.service.api.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserConsumerController {

/*    @Autowired
    private RestTemplate restTemplate;*/

    @Value("${user.service.provider.name}")
    private String userServiceProviderName;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    //    return restTemplate.getForObject("http://"+userServiceProviderName+"/user/"+id,User.class);
    }

    @GetMapping("/user/findAll")
    public Collection<User> findAll() {
        return userService.findAll();
      //  UserConsumerHystrixCommand command = new UserConsumerHystrixCommand(userServiceProviderName,restTemplate);
       // return command.execute();
        //  return restTemplate.getForObject("http://"+userServiceProviderName+"/user/findAll", Collection.class);
    }

    @PostMapping("/user/save")
    public Boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
        //return restTemplate.postForObject("http://"+userServiceProviderName+"/user/save", user, Boolean.class);
    }

}
