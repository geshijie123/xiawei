package com.xw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xw.entity.test.User;
import com.xw.mapper.UserMapper;
import com.xw.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Cacheable(value = "User")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


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
    @Cacheable(keyGenerator = "myKeyGenerator", unless = "#result eq null")
    public List<Map<String, Object>> mapperSelectBySql() {
        return baseMapper.mapperSelectBySql("1");
    }
}
