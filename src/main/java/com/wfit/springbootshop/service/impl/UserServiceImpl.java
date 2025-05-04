package com.wfit.springbootshop.service.impl;

import com.wfit.springbootshop.mapper.UserMapper;
import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.UserService;
import com.wfit.springbootshop.service.ex.InsertException;
import com.wfit.springbootshop.service.ex.UserNotExistException;
import com.wfit.springbootshop.service.ex.UsernameDuplicatedException;
import com.wfit.springbootshop.service.ex.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper UserMapper;


    @Override
    public void addUser(User user) {
        UserMapper.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        UserMapper.updateUser(user);
    }

    @Override
    public void delUser(String id) {
        UserMapper.delUser(id);
    }


    @Override
    public List<User> queryUser() {
        List<User> list =  UserMapper.queryUser();
        return list;
    }

    public String getNewUserId(List<User> list) {
        int ans = 0;
        for (User user : list) {
            int tmp = Integer.parseInt(user.getId());
            ans = Math.max(ans,tmp);
        }

        ans += 1;
        return Integer.toString(ans);
    }
    
    @Override
    public void registerUser(User user) {
        List<User> list = UserMapper.queryUser();//得到查询的所有值
        boolean flag = true;
        for (User t : list) {

            if(user.getUsername().equals(t.getUsername())){ //如果用户名相等
                throw new UsernameDuplicatedException("用户名被占用");
            }
        }
        user.setId(getNewUserId(list));
        //将数据插入到数据库中

        UserMapper.saveUser(user);


    }

    //注意使用时
    @Override
    public User login(String username, String password) {
        List<User> list = UserMapper.queryUser();//得到查询的所有值
        for (User user : list) {
            if(user.getUsername().equals(username)){
//                System.out.println(user.getPassword());
//                System.out.println(password);
                if(user.getPassword().equals(password))return user;
                else throw new WrongPasswordException("密码不正确!");
            }
        }

        //说明找不到
        throw new UserNotExistException("用户名不存在");
    }

    @Override
    public void updatePasswordById(String id, String password) {
        int res = UserMapper.updatePasswordById(id,password);
        if(res == 0) throw new InsertException("插入异常");
    }

    @Override
    public User getUserById(String id) {
        User user = UserMapper.queryUserById(id);
        System.out.println("user" + user);
        if(user == null) throw new UserNotExistException("用户数据不存在");
        return user;
    }

    @Override
    public void changeUserByid(String id, String phone, String email, int gender) {
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setEmail(email);
        user.setGender(gender); //String id, String phone, String email, String gender
        UserMapper.updateInfoById(id,phone,email,gender);

    }
}
