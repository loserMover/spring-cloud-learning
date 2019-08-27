package com.home.spring.cloud.user.service.web.controller;

import com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.domain.User;
import com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Random random = new Random();

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/findAll")
    @HystrixCommand(
            commandProperties = { // Command 配置
                    // 设置操作时间为 100 毫秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallbackForFindAll" // 设置 fallback 方法
    )
    public Collection<User> findAll() throws InterruptedException {
        long executeTime = random.nextInt(200);
        // 通过休眠来模拟执行时间
        System.out.println("Execute Time : " + executeTime + " ms");
        Thread.sleep(executeTime);
        return userService.findAll();
    }

    @PostMapping("/user/save")
    public Boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 达到熔断返回null集合
     * @return
     */
    private Collection<User> fallbackForFindAll(){
        return Collections.emptyList();
    }
}
