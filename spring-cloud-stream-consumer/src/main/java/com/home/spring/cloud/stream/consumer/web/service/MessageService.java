package com.home.spring.cloud.stream.consumer.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.spring.cloud.stream.consumer.stream.MessageSink;
import com.home.spring.cloud.stream.consumer.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class MessageService {

    @Autowired
    private MessageSink messageSink;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
        SubscribableChannel subscribableChannel = messageSink.inputMessage();
        subscribableChannel.subscribe(message -> {
            System.out.println("Subscribe by SubscribableChannel");
            try {
                User user = objectMapper.readValue(message.getPayload().toString(), User.class);
                userService.saveUser(user);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        SubscribableChannel subscribableChannelActiveMQ = messageSink.inputActiveMQMessage();
        subscribableChannelActiveMQ.subscribe(message -> {
            System.out.println("Subscribe by SubscribableChannel");
            if (message instanceof GenericMessage){
                GenericMessage genericMessage = (GenericMessage)message;
                User user = (User)genericMessage.getPayload();
                userService.saveUser(user);
            }
        });


    }

    @ServiceActivator(inputChannel=MessageSink.INPUT)
    public void listen(String message) throws IOException {
        System.out.println("Subscribe by ServiceActivator");
        User user = objectMapper.readValue(message,User.class);
        userService.saveUser(user);
    }


    @StreamListener(value = MessageSink.INPUT)
    public void onMessage(String message) throws IOException {
        System.out.println("Subscribe by StreamListener");
        User user = objectMapper.readValue(message,User.class);
        userService.saveUser(user);
    }

    @StreamListener(value = "spring-cloud-stream-active")
    public void onActiveMQMessage(User user) throws IOException {
        System.out.println("Subscribe by StreamListener");
        userService.saveUser(user);
    }






}
