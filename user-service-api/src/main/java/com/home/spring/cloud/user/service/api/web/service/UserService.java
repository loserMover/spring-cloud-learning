package com.home.spring.cloud.user.service.api.web.service;

import com.home.spring.cloud.user.service.api.web.domain.User;
import com.home.spring.cloud.user.service.api.web.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * 用户信息接口
 */
@FeignClient(name = "${user.service.provider.name}",fallback = UserServiceFallback.class)
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

    /**
     * 返回所有用户信息
     * @return
     */
    @GetMapping("/user/findAll")
    Collection<User> findAll();

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @PostMapping("/user/save")
    Boolean saveUser(User user);

}
