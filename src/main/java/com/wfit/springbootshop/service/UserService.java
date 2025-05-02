package com.wfit.springbootshop.service;

import com.wfit.springbootshop.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User student);
    public void updateUser(User student);
    public void delUser(String id);
    public List<User> queryUser();

}
