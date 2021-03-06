package com.xw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xw.mapper")
public class XwApplication {
    public static void main(String[] args) {
        SpringApplication.run(XwApplication.class, args);
    }
}
