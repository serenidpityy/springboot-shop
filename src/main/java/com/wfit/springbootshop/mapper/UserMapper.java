package com.wfit.springbootshop.mapper;
import com.wfit.springbootshop.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//通过写这个函数来关联sql语句和java语句
@Mapper
public interface UserMapper {
    public void saveUser(User user);
    public void updateUser(User user);
    public void delUser(String id);
    public List<User> queryUser();
    public User queryUserById(String id);
    public int updatePasswordById(String id, String password);
    public void updateInfoById(String id, String phone, String email, int gender);
    public int getmemberById(String id);
    public void updatememberByid(String id,int member);
    //通过userid查询所有信息
    public List<Address>  queryAddressByUserid(String userid);
    //通过id删除信息
    public void delAddressByid(String id);
    //添加地址信息 id,userid,address,addresstype,consignee,phone
    public void addAddress(String id,String userid,String address,String addresstype,String consignee,String phone);
}
