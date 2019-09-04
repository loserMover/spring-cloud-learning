package com.home.spring.cloud.stream.provider.web.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.spring.cloud.stream.provider.stream.MessageSource;
import com.home.spring.cloud.stream.provider.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
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
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/send")
    public boolean sendMessage(@RequestBody User user) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(user);
        return messageSource.outputMessage().send(MessageBuilder.withPayload(payload).build());
    }

    @PostMapping("/activemq/send")
    public boolean sendActiveMQMessage(@RequestBody User user) throws JsonProcessingException {
        GenericMessage message = new GenericMessage(user);
        return messageSource.activeOutputMessage().send(message);
    }
}
