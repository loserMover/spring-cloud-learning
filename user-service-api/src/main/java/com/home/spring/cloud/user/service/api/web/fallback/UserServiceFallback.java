package com.home.spring.cloud.user.service.api.web.fallback;

import com.home.spring.cloud.user.service.api.web.domain.User;
import com.home.spring.cloud.user.service.api.web.service.UserService;

import java.util.Collection;
import java.util.Collections;

public class UserServiceFallback implements UserService {
    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Boolean saveUser(User user) {
        return Boolean.FALSE;
    }
}
