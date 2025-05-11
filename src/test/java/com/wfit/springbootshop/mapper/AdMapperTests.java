package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.Address;
import com.wfit.springbootshop.entity.Product;
import com.wfit.springbootshop.entity.Ad;
import com.wfit.springbootshop.service.ProductService;
import com.wfit.springbootshop.service.AdService;
import com.wfit.springbootshop.service.ex.ServiceException;
import com.wfit.springbootshop.service.ex.AdnameDuplicatedException;
import com.wfit.springbootshop.service.impl.AdServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.max;

@SpringBootTest //表示当前的类是测试类
public class AdMapperTests {
    @Autowired
    AdMapper adMapper; //写这个就可以通过方法来调用sql
    @Autowired
    private AdService adService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private ProductService productService;
    @Test //测试查询
    public void queryAdBy() {
        List<Ad>list = adMapper.queryAd();
        for (Ad ad : list) {
            System.out.println("ID: " + ad.getId());
            System.out.println("用户名: " + ad.getAdname());
            System.out.println("密码: " + ad.getPassword());
            System.out.println("电话: " + ad.getPhone());
            System.out.println("邮箱: " + ad.getEmail());
            System.out.println("性别: " + ad.getGender());
            System.out.println("----------------------");
        }
    }

    @Test
    public void insertAd() {
        Ad ad = new Ad();
        ad.setAdname("123");
        ad.setPassword("123");
        ad.setId("5");
        adMapper.saveAd(ad);
    }

    @Test
    public void delAd() {
        adMapper.delAd("5");
    }

    @Test
    public void updateAd() {
        Ad ad = new Ad();
        ad.setAdname("啊啊");
        ad.setPassword("123");
        ad.setId("0");
        adMapper.updateAd(ad);
    }

    @Test
    public void regAdtest() {
        try{

            Ad ad = new Ad();
            ad.setAdname("yier");
            ad.setPassword("123456");
            adService.registerAd(ad);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void loginAdtest() {
        try{
            Ad ad = new Ad(); //'张三', '111111
            ad.setAdname("张三");
            ad.setPassword("1");
            adService.login(ad.getAdname(), ad.getPassword());
            System.out.println("登录成功");
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void test1(){
        adService.updateInfoById("3","啊啊","2345","234rt",1);
    }

    @Test
    public void test2(){
        adService.updatePasswordById("0","23451");
    }



}

