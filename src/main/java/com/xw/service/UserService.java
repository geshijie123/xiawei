package com.xw.service;

import com.xw.entity.test.User;
import com.xw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

  int saveUser(User user);

}
