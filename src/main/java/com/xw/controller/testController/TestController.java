package com.xw.controller.testController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/testAPI")
    public  String test(){
        return "test str";
    }
}
