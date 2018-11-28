package com.xw.service.impl;

import com.xw.entity.test.User;
import com.xw.mapper.UserMapper;
import com.xw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }
}
