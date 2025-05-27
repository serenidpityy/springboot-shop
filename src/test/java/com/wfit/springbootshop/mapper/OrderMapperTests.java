package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.*;
import com.wfit.springbootshop.service.CartService;
import com.wfit.springbootshop.service.OrderService;
import com.wfit.springbootshop.service.ProductService;
import com.wfit.springbootshop.service.UserService;
import com.wfit.springbootshop.service.ex.ServiceException;
import com.wfit.springbootshop.service.ex.UsernameDuplicatedException;
import com.wfit.springbootshop.service.impl.UserServiceImpl;
import com.wfit.springbootshop.vo.CartVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.max;

@SpringBootTest //表示当前的类是测试类
public class OrderMapperTests {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Test
    public void queryOrder(){
        try{
            List<Order> list = orderMapper.queryOrder();
            for(Order order:list){
                System.out.println(order);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }


    @Test
    public void addOrder(){
        try{
            Order order = new Order();
            order.setOid("1");
            order.setPid("1");
            order.setTitle("1");
            order.setUsername("张三");
            order.setImage("1");
            order.setPrice(1);
            order.setNum(1);
            order.setState(0);
            order.setComment("12 ");

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
//    // 根据用户ID获取订单列表
//    List<Order> getOrdersByUserId(String uid);
//    // 修改订单状态
//    int updateOrderState(String oid, int state);
//    // 修改订单评价
//    int updateOrderComment(String oid, String comment);
//
//    // 根据订单ID删除订单
//    int deleteOrderById(String oid);
    @Test
    public void getOrdersByUserId(){
        try{
            List<Order>list = orderMapper.getOrdersByUserId("1");
            for(Order order:list){
                System.out.println(order);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    @Test
    public void updateOrderState(){
        try{
            orderMapper.updateOrderState("1",1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    @Test
    public void updateOrderComment(){
        try{
            orderMapper.updateOrderComment("1","很好");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    @Test
    public void deleteOrderById(){
        try{
            orderMapper.deleteOrderById("1");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }


    @Test
    public void getOrdercommetsByPid(){
        try{
            List<Order>list = orderService.getOrdercommetsByPid("10000036");
            for(Order order:list){
                System.out.println(order);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
