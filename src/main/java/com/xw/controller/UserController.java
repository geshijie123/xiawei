package com.xw.controller;


import com.xw.entity.test.User;
import com.xw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService UserService;

    @RequestMapping("/save")
    public String saveUser(@RequestParam(value = "name",required=true) String name ,
                           @RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
                           @RequestParam(value = "email", required = false, defaultValue = "") String email){
        User user=new User();
        user.setAge(age);
        user.setEmail(email);
        user.setName(name);
        return UserService.saveUser(user)+"";
    }
}
