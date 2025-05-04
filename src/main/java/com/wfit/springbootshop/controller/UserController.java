package com.wfit.springbootshop.controller;

import com.wfit.springbootshop.entity.Address;
import com.wfit.springbootshop.entity.User;
import com.wfit.springbootshop.service.UserService;
import com.wfit.springbootshop.util.JsonResult;
import jakarta.servlet.http.HttpSession;
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

    /**
     * 1. 接收数据方式：请求处理方法的参数列表设置为pojo类型来接收前端的数据，
     * SpringBoot会将前端的url地址中的参数名和pojo类的属性性名进行比较，如果这两个名称项目，则将值注入到pojo类中对应的属性上
     */
    @PostMapping("/reg")
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


    /**
     * 2. 接收数据方式：请求处理方法的参数列表设置为非pojo类型
     * SpringBoot会直接将请求的参数名和方法的参数名直接进行比较，如果名称相同则自动完成值的依赖注入
     */
    @PostMapping("/login")
    public JsonResult<Void> login(String username, String password, HttpSession session){
        User data = userService.login(username,password);
        session.setAttribute("id",data.getId());
        session.setAttribute("username",data.getUsername());
        session.setAttribute("password",data.getPassword());
        //获取session中绑定的数据
//        System.out.println(getidFromSession(session));
//        System.out.println(getusernameFromSession(session));

        return new JsonResult<>(OK);
    }

    @PostMapping("/updatePassword")
    public JsonResult<Void> updatePassword(String oldPassword,String newPassword, HttpSession session){
        if(oldPassword.equals(getpasswordFromSession(session)) ){
            String id = getidFromSession(session);
            userService.updatePasswordById(id,newPassword);
            setpasswordFromSession(session,newPassword);
            User user = new User();
            user.setId(id);
            user.setPassword(newPassword);
            return new JsonResult<>(OK);
        }return new JsonResult<>(Password_inconsistency);
    }

    @PostMapping("/getUserById")
    public JsonResult<User> getUserById(String id,HttpSession session){
        User user = userService.getUserById(getidFromSession(session));
        return new JsonResult<>(OK,user);
    }

    @PostMapping("/changeUserByid")
    public JsonResult<Void> changeUserByid(String id, String phone, String email, int gender, HttpSession session){
        System.out.println(phone);
        System.out.println(email);
        System.out.println(gender);
        id = getidFromSession(session);
        System.out.println(id);
        userService.changeUserByid(id,phone,email,gender);
        return new JsonResult<>(OK);
    }

    @PostMapping("/getmember")
    public JsonResult<User> getmember(HttpSession session){
        String id = getidFromSession(session);

        User user = new User();
        user.setMember(userService.getmemberById(id));
        return new JsonResult<>(OK,user);
    }

    @PostMapping("/bemember")
    public JsonResult<Void> bemember(HttpSession session){
        String id = getidFromSession(session);
        userService.updatememberByid(id,1);
        return new JsonResult<>(OK);
    }

    @PostMapping("/nobemember")
    public JsonResult<Void> nobemember(HttpSession session){
        String id = getidFromSession(session);
        userService.updatememberByid(id,0);
        return new JsonResult<>(OK);
    }


    @PostMapping("/getaddress")
    public JsonResult<List<Address>> getaddress(HttpSession session){
        String id = getidFromSession(session);
        List<Address> list = userService.queryAddressByUserid(id);
        for(Address address : list){
            System.out.println(address.getAddressType());
        }
        return new JsonResult<>(OK,list);
    }

    @PostMapping("/deladdress")
    public JsonResult<Void> deladdress(@RequestParam("id") String id){
        System.out.println(id);
        userService.delAddressByid(id);
        return new JsonResult<>(OK);
    }

}
