package com.xw.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xw.entity.test.User;
import com.xw.service.UserService;
import com.xw.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.baomidou.mybatisplus.extension.api.Assert.*;

@RestController
@RequestMapping("user")
public class UserController extends ApiController {

    @Autowired
    UserService userService;

    /**
     * 插入n条测试数据
     * @param num n
     * @return
     */
    @RequestMapping("/insert")
    public Object createUsers(@RequestParam(value = "num",required = false,defaultValue = "0") int num){
        notNull(ErrorCode.DATA_ERROR,num);
        fail(num<=0, ErrorCode.DATA_ERROR);
        for(int i=0;i<num;i++){
            User user=new User();
            user.setName("name"+i);
            user.setAge(i);
            user.setEmail("@@@"+i*i);
            userService.save(user);
        }
        return success("添加了"+num);
    }

    /**
     *  service保存user
     * @param name
     * @param age
     * @param email
     * @return
     */
    @RequestMapping("/service_save")
    public Object service_save(@RequestParam(value = "name",required=true) String name ,
                           @RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
                           @RequestParam(value = "email", required = false, defaultValue = "") String email){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return userService.save(user)+"";
    }
    /**
     *  service保存user
     * @param name
     * @param age
     * @param email
     * @return
     */
    @RequestMapping("/mapper_save")
    public Object mapper_save(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
                              @RequestParam(value = "email", required = false, defaultValue = "") String email){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return userService.saveUser(user)+"";
    }

    @RequestMapping("/service_selectAll")
    public Object service_selectAll(){
        List<User> list = userService.list();
        return success(list);
    }

    @RequestMapping("/mapper_selectAll")
    public Object mapper_selectAll(){
        List<User> list = userService.mapperSelectAll();
        return success(list);
    }

    /**
     * 条件查询筛选列 代码实现
     * @return
     */
    @RequestMapping("/mapper_selectMapColumnByWhere")
    public Object mapper_selectMapColumnByWhere(){
        List<Map<String, Object>> maps = userService.mapper_selectMapColumnByWhere();
        return success(maps);
    }
    /**
     * 条件查询筛选列 sql实现
     * @return
     */
    @RequestMapping("/mapper_selectMapBySql")
    public Object mapper_selectMapBySql(){
        List<Map> maps = userService.mapperSelectBySql();
        return success(maps);
    }
    /**
     * 条件查询筛选列 sql实现
     * @return
     */
    @RequestMapping("/map_page")
    public Object map_page(Page page, boolean listMode){
        if (listMode) {
            // size 小于 0 不在查询 total 及分页，自动调整为列表模式。
            // 注意！！这个地方自己控制好！！
            page.setSize(-1);
        }
        IPage<Map> mapIPage = userService.selectUserPage(page, "@@@");
        return success(mapIPage);
    }


    @RequestMapping("/remove")
    public Object removeUser(String id){
        return userService.removeById(id);
    }
    @RequestMapping("/delete")
    public Object deleteUser(String id){
        return userService.delete(id);
    }
}
