package com.home.spring.cloud.config.client.web.web.controller;

import com.home.spring.cloud.config.client.web.web.configuration.LearningProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(LearningProperties.class)
@RequestMapping("/learn")
public class LearningController {

    @Autowired
    private LearningProperties learningProperties;

    @GetMapping("/name")
    public String learnName() {
        return "I LOVE YOU " + learningProperties.getName();
    }

}
