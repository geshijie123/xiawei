package com.xw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xw.entity.test.User;
import com.xw.mapper.UserMapper;
import com.xw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return baseMapper.insert(user);
    }

    @Override
    @CacheEvict(value = "User", allEntries=true)
    public int delete(String id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<User> mapperSelectAll() {
        return baseMapper.selectByMap(null);
    }

    @Override
    public List<Map<String, Object>> mapper_selectMapColumnByWhere() {
        return baseMapper.selectMaps(new QueryWrapper<User>().select("email").eq("id","1"));
    }

    @Override
    @Cacheable(value = "User",keyGenerator = "myKeyGenerator", unless = "#result eq null")
    public List<Map> mapperSelectBySql() {
        return baseMapper.mapperSelectBySql("1");
    }

    @Override
    public IPage<Map> selectUserPage(Page page, String state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个


//        return baseMapper.selectByPage(page, state);
        return userMapper.selectByPage(page, state);



    }
}
