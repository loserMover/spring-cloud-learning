package com.home.spring.cloud.stream.consumer.web.service;

import com.home.spring.cloud.stream.consumer.web.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IMemoryUserServiceImpl implements UserService {

    private final static Map<Long, User> mapUsers = new ConcurrentHashMap<>();

    @Override
    public User findById(Long id) {
        return mapUsers.get(id);
    }

    @Override
    public Collection<User> findAll() {
        return mapUsers.values();
    }

    @Override
    public Boolean saveUser(User user) {
        return null == mapUsers.put(user.getId(),user);
    }
}
