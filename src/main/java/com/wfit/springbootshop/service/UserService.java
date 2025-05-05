package com.wfit.springbootshop.service;

import com.wfit.springbootshop.entity.Address;
import com.wfit.springbootshop.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void delUser(String id);
    public List<User> queryUser();
    public void registerUser(User user);
    public User login(String username, String password);
    public void updatePasswordById(String id, String password);
    public User getUserById(String id);
    public void changeUserByid(String id,String phone,String email,int gender);
    //getmember bemember nobemember
    public int getmemberById(String id);
    public void updatememberByid(String id,int member);
    public List<Address> queryAddressByUserid(String userid);
    public void delAddressByid(String id);

}
