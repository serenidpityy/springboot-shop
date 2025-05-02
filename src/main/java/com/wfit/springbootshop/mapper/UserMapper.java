package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public void saveUser(User user);
    public void updateUser(User user);
    public void delUser(String id);
    public List<User> queryUser();


}
