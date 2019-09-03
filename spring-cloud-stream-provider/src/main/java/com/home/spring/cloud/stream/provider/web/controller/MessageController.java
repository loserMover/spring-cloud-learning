package com.home.spring.cloud.stream.provider.web.controller;


import com.home.spring.cloud.stream.provider.stream.MessageSource;
import com.home.spring.cloud.stream.provider.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 18:14 2019/9/3
 * @modified by:
 */

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/send")
    public boolean sendMessage(@RequestBody User user){
        return messageSource.outputMessage().send(user);
    }

}
