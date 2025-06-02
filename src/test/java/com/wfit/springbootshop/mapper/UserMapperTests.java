package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.Address;
import com.wfit.springbootshop.entity.Product;
import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.ProductService;
import com.wfit.springbootshop.service.UserService;
import com.wfit.springbootshop.service.ex.ServiceException;
import com.wfit.springbootshop.service.ex.UsernameDuplicatedException;
import com.wfit.springbootshop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.max;

@SpringBootTest //表示当前的类是测试类
public class UserMapperTests {
    @Autowired
    UserMapper userMapper; //写这个就可以通过方法来调用sql
    @Autowired
    private UserService userService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private ProductService productService;
//    @Test //测试查询
//    public void queryUserBy() {
//        List<User>list = userMapper.queryUser();
//        for (User user : list) {
//            System.out.println("ID: " + user.getId());
//            System.out.println("用户名: " + user.getUsername());
//            System.out.println("密码: " + user.getPassword());
//            System.out.println("电话: " + user.getPhone());
//            System.out.println("邮箱: " + user.getEmail());
//            System.out.println("性别: " + user.getGender());
//            System.out.println("----------------------");
//        }
//    }
//
//
//    @Test
//    public void regUsertest() {
//        try{
//
//            User user = new User();
//            user.setUsername("yier");
//            user.setPassword("123456");
//            userService.registerUser(user);
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void loginUsertest() {
//        try{
//            User user = new User(); //'张三', '111111
//            user.setUsername("张三1");
//            user.setPassword("111111");
//            userService.login(user.getUsername(), user.getPassword());
//            System.out.println("登录成功");
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void print(String s) {System.out.println(s);}
//    public void print(int x){System.out.println(x);}
//
//    public void print(User user)
//    {
//        System.out.println("-----------------");
//        print(user.getId());
//        print(user.getUsername());
//        print(user.getPassword());
//        print(user.getPhone());
//        print(user.getEmail());
//        print(user.getGender());
//        System.out.println("-----------------");
//    }
//
//    public void print(Address address)
//    {
//        System.out.println("-----------------");
//        print(address.getId());
//        print(address.getUserid());
//        print(address.getAddressType());
//        print(address.getAddress());
//        print(address.getPhone());
//    }
//
//
//    //测试密码的更新和查询的sql语句
//    @Test
//    public void updateUserpasswordById() {
//        try{
//            User user = new User();
//            user.setId("8");
//            user.setPassword("23456");
//            int t = userMapper.updatePasswordById(user.getId(),user.getPassword());
//            //User user2 = userMapper.queryUserById(user.getId());
//            print(t);
//            //print(user2);
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void updateInfoById() {
//        try{
//            User user = new User();
//            user.setId("2");
//            user.setPhone("2345");
//            user.setEmail("yier");
//            user.setGender(0);
//            userMapper.updateInfoById(user.getId(),user.getPhone(),user.getEmail(),user.getGender());
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void getUserById() {
//        try{
//            userService.getUserById("2");
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void getmemberById() {
//        try{
//            int id = userMapper.getmemberById("2");
//            print(id);
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
////    @Test
////    public void updatememberById() {
////        try{
////
////        }catch (ServiceException e){
////            System.out.println(e.getClass().getSimpleName());
////            System.out.println(e.getMessage());
////
////        }
////    }
//
//    @Test
//    public void queryAddressByUserid(){
//        try{
//            List<Address>list = userMapper.queryAddressByUserid("2");
//            for(Address address : list){
//                print(address);
//            }
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void delAddressByid(){
//        try{
//            userMapper.delAddressByid("id005");
//
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void addAddress(){
//        try{
//            userMapper.addAddress("id007","1","成都市武侯区 WW 街 78 号","公司地址",
//                    "张三","1234567");
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public  List<Product> getPriority(List<Product> list) {
//        // 使用Collections.sort()方法，传入自定义的比较器
//        Collections.sort(list, new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                // 按照优先级从大到小排序
//                return Integer.compare(p2.getPriority(), p1.getPriority());
//            }
//        });
//        return list;
//    }
//
//    @Test // 测试查询
//    public void queryProductBy() {
//        List<Product> list = productMapper.queryProduct(); // 调用Mapper接口的查询方法
//        list = getPriority(list);
//        for (Product product : list) {
//            System.out.println("商品ID: " + product.getId());
//            System.out.println("分类ID: " + product.getCategoryId());
//            System.out.println("商家ID: " + product.getMerchantid());
//            System.out.println("商品标题: " + product.getTitle());
//            System.out.println("商品卖点: " + product.getSellPoint());
//            System.out.println("商品单价: " + product.getPrice());
//            System.out.println("库存数量: " + product.getNum());
//            System.out.println("图片路径: " + product.getImage());
//            System.out.println("商品状态: " + product.getStatus());
//            System.out.println("显示优先级: " + product.getPriority());
//            System.out.println("-----------------------------");
//        }
//    }
//
//
//    @Test
//    void priorityProduct()
//    {
//        try{
//            List<Product> list = productMapper.queryProduct(); // 调用Mapper接口的查询方法
//
//
//
//
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void findproductByid(){
//        try{
//            Product product = productMapper.findProductById("10000033");
//            System.out.println(product.getSellPoint());
//
//
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void getPrice(){
//        try{
//            int val = productMapper.findpriceProductById("10000033");
//            System.out.println(val);
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }

}

