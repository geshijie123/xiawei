package com.xw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xw.entity.test.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

  int saveUser(User user);


  int delete(String id);

  List<User> mapperSelectAll();

  List<Map<String, Object>> mapper_selectMapColumnByWhere();




  List<Map> mapperSelectBySql();

  /**
   * 自定义分页service
   * @param page
   * @param state
   * @return
   */
   IPage<Map> selectUserPage(Page page, String state);
}
