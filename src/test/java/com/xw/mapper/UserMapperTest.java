package com.xw.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xw.XwApplication;
import com.xw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = XwApplication.class)
@WebAppConfiguration
public class UserMapperTest {


    @Autowired
    UserService userService;

    @Test
    public void selectByPage() {
        Page page=new Page();
        page.setSize(10L);
        page.setTotal(1L);
        IPage<Map> userIPage = userService.selectUserPage(page, "@@");
        System.out.println(userIPage.getRecords().size());
    }
    @Test
    public void mapperSelectBySql() {

        List<Map> maps = userService.mapperSelectBySql();
        System.out.println(maps.size());
    }
}