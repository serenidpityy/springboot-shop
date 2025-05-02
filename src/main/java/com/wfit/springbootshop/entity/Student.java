package com.wfit.springbootshop.entity;

import lombok.Data;

@Data //节省getter/setter方法的编写，直接使用
public class Student {
    private String id;
    private String name;
    private int age;
    private String sex;
}
