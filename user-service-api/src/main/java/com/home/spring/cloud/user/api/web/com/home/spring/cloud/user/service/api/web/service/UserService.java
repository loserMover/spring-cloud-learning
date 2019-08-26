package com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.service;

import com.home.spring.cloud.user.api.web.com.home.spring.cloud.user.service.api.web.domain.User;

import java.util.Collection;

/**
 * 用户信息接口
 */
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 返回所有用户信息
     * @return
     */
    Collection<User> findAll();

    /**
     * 保存用户西悉尼
     * @param user
     * @return
     */
    Boolean saveUser(User user);

}
