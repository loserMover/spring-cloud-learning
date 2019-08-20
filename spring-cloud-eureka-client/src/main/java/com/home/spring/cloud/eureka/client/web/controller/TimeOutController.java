package com.home.spring.cloud.eureka.client.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 15:07 2019/8/20
 * @modified by:
 */
@RestController
public class TimeOutController {

    @GetMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
        return "hello";
    }
}
