package com.wfit.springbootshop.controller;

import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.UserService;
import com.wfit.springbootshop.service.ex.UsernameDuplicatedException;
import com.wfit.springbootshop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//@Controller 和 @ResponseBody
@RequestMapping("/user") // 添加类级别路径  访问时写:localhost:9999/user/add
public class UserController extends BaseController{
    @Autowired
    UserService userService;


    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @GetMapping("/add") //给其发送json文件时，就会接收到,赋值给user
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

    @GetMapping("/reg")
    public JsonResult<Void> reg(User user){
        userService.registerUser(user);
        return new JsonResult<>(OK);
    }


//    @GetMapping("/reg")
//    public JsonResult<Void> reg(User user){
//        //创建响应的结果对象
//        JsonResult<Void> jsonResult = new JsonResult<>();
//
//        try{
//            userService.registerUser(user);
//            jsonResult.setState(200);
//            jsonResult.setMessage("用户注册成功");
//        }catch (UsernameDuplicatedException e){
//            jsonResult.setState(4000);
//            jsonResult.setMessage("用户名被占用");
//        }catch (Exception e){
//            jsonResult.setState(4000);
//            jsonResult.setMessage("异常");
//        }
//
//        return jsonResult;
//    }



}
