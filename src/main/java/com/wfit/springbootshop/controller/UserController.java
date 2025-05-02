package com.wfit.springbootshop.controller;

import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//@Controller 和 @ResponseBody
@RequestMapping("/user") // 添加类级别路径  访问时写:localhost:9999/user/add
public class UserController {
    @Autowired
    UserService userService;


    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @GetMapping("/add")
    public Object addUser(@RequestBody User user){
        userService.addUser(user);
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data",user);
        return map;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Object updateUser(@RequestBody User user){
        userService.updateUser(user);
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data",user);
        return map;
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @GetMapping("/del")
    public Object delUser(String id){
        userService.delUser(id);
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data","删除用户id为:" + id);
        return map;
    }

    @GetMapping("/query")
    public Object queryUser(){
        List<User> list = userService.queryUser();
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data",list);
        return map;
    }




}
