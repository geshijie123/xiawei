package com.xw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xw.entity.test.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

  int saveUser(User user);


  int delete(String id);

  List<User> mapperSelectAll();

  List<Map<String, Object>> mapper_selectMapColumnByWhere();

  List<Map<String, Object>> mapperSelectBySql();
}
