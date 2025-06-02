package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.Address;
import com.wfit.springbootshop.entity.Product;
import com.wfit.springbootshop.entity.Seller;
import com.wfit.springbootshop.service.ProductService;
import com.wfit.springbootshop.service.SellerService;
import com.wfit.springbootshop.service.ex.ServiceException;
import com.wfit.springbootshop.service.ex.SellernameDuplicatedException;
import com.wfit.springbootshop.service.impl.SellerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.max;

@SpringBootTest //表示当前的类是测试类
public class SellerMapperTests {
    @Autowired
    SellerMapper sellerMapper; //写这个就可以通过方法来调用sql
    @Autowired
    private SellerService sellerService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private ProductService productService;
//    @Test //测试查询
//    public void querySellerBy() {
//        List<Seller>list = sellerMapper.querySeller();
//        for (Seller seller : list) {
//            System.out.println("ID: " + seller.getId());
//            System.out.println("用户名: " + seller.getSellername());
//            System.out.println("密码: " + seller.getPassword());
//            System.out.println("电话: " + seller.getPhone());
//            System.out.println("邮箱: " + seller.getEmail());
//            System.out.println("性别: " + seller.getGender());
//            System.out.println("----------------------");
//        }
//    }
//
//    @Test
//    public void insertSeller() {
//        Seller seller = new Seller();
//        seller.setSellername("123");
//        seller.setPassword("123");
//        seller.setId("5");
//        sellerMapper.saveSeller(seller);
//    }
//
//    @Test
//    public void delSeller() {
//        sellerMapper.delSeller("5");
//    }
//
//    @Test
//    public void updateSeller() {
//        Seller seller = new Seller();
//        seller.setSellername("啊啊");
//        seller.setPassword("123");
//        seller.setId("0");
//        sellerMapper.updateSeller(seller);
//    }
//
//    @Test
//    public void regSellertest() {
//        try{
//
//            Seller seller = new Seller();
//            seller.setSellername("yier");
//            seller.setPassword("123456");
//            sellerService.registerSeller(seller);
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void loginSellertest() {
//        try{
//            Seller seller = new Seller(); //'张三', '111111
//            seller.setSellername("张三");
//            seller.setPassword("1");
//            sellerService.login(seller.getSellername(), seller.getPassword());
//            System.out.println("登录成功");
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void querySellerById(){
//        Seller seller = sellerMapper.querySellerById("5");
//        System.out.println(seller);
//    }
//
//    @Test  //Seller(id=5, sellername=素数, password=11, phone=null, email=null, gender=0)
//    public void updatePasswordById(){
//        sellerMapper.updatePasswordById("5","12345");
//    }
//
//    @Test
//    public void updateInfoById(){
//        sellerMapper.updateInfoById("2","张三","12345","@qq.com",0);
//    }

}

