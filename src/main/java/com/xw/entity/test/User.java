package com.xw.entity.test;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class User {

    @TableId
    private Long id;
    private String name;
    private int isDelete;
    private Date createTime;
    private Date updateTime;
    private Integer age;
    private String email;
}