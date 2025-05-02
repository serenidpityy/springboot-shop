package com.wfit.springbootshop.entity;

import lombok.Data;

@Data
public class User {
    private String id;// --AUTO_INCREMENT '用户id',
    private String username;//VARCHAR(20) NOT NULL UNIQUE, --'用户名',
    private String password;//CHAR(32) //NOT NULL, -- '密码',
    private String phone; //VARCHAR(20)  //,-- '电话号码',
    private String email; //VARCHAR(30)  //,-- '电子邮箱',
    private int gender;//,-- '性别:0-女，1-男' 2-未知,

}
