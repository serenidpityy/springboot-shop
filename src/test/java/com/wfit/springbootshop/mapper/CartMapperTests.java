package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.Address;
import com.wfit.springbootshop.entity.Cart;
import com.wfit.springbootshop.entity.Product;
import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.CartService;
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
public class CartMapperTests {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartService cartService;
    //插入购物车数据
//    public int insertCart(Cart cart);
//
//    //更新购物车某件商品的数量
//    public int updateNumByCid(String cid,int num);
//
//    //根据用户的id和商品的id来查询购物车的数据
//    public Cart findByUidAndPid(String uid,String pid);
//    cid INT ,-- '购物车数据id',
//	uid INT NOT NULL,-- '用户id',
//	pid INT NOT NULL ,--'商品id',
//	price INT ,-- '加入时商品单价',
//	num INT ,-- '商品数量',
    @Test
    public void insertCart(){
        try{
            Cart cart = new Cart();
            cart.setCid("2");
            cart.setUid("2");
            cart.setPid("2");
            cart.setPrice(10);
            cart.setNum(10);

            cartMapper.insertCart(cart);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateNumByCid(){
        try{
            Cart cart = new Cart();
            int rows =  cartMapper.updateNumByCid("1",10);

        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findByUidAndPid(){
        try{
            Cart cart = cartMapper.findByUidAndPid("1","1");
            System.out.println(cart);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addToCart(){
        try{
            cartService.addToCart("3","1",121);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
