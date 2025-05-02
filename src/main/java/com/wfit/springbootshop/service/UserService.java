package com.wfit.springbootshop.service;

import com.wfit.springbootshop.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void delUser(String id);
    public List<User> queryUser();
    public void registerUser(User user);
}
