package com.wfit.springbootshop.service.impl;

import com.wfit.springbootshop.mapper.UserMapper;
import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper UserMapper;


    @Override
    public void addUser(User student) {
        UserMapper.saveUser(student);
    }

    @Override
    public void updateUser(User student) {
        UserMapper.updateUser(student);
    }

    @Override
    public void delUser(String id) {
        UserMapper.delUser(id);
    }


    @Override
    public List<User> queryUser() {
        return UserMapper.queryUser();
    }
}
