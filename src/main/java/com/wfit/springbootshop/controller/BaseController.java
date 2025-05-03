package com.wfit.springbootshop.controller;

import com.wfit.springbootshop.service.ex.ServiceException;
import com.wfit.springbootshop.service.ex.UserNotExistException;
import com.wfit.springbootshop.service.ex.UsernameDuplicatedException;
import com.wfit.springbootshop.service.ex.WrongPasswordException;
import com.wfit.springbootshop.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ExceptionHandler;

//控制层类的基类
public class BaseController {
    //状态成功的状态码
    public static final int OK = 200;

    //请求处理方法，返回值就是需要传递给全端的数据
    //自动将异常对象传递给此方法的参数列表上
    //当前项目中产生了异常，统一拦截到此方法中，返回值返回到前端
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> jsonResult = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            jsonResult.setState(4000);
            jsonResult.setMessage("用户名被占用");
        }else if(e instanceof UserNotExistException){
            jsonResult.setState(5001);
            jsonResult.setMessage("用户名不存在");
        }else if(e instanceof WrongPasswordException){
            jsonResult.setState(5002);
            jsonResult.setMessage("密码错误");
        }else if(e instanceof Exception){
            jsonResult.setState(5000);
            jsonResult.setMessage("注册时产生未知异常");
        }
        return jsonResult;
    }

    protected final String getidFromSession(HttpSession session){
        return (String)session.getAttribute("id");
    }

    protected final String getusernameFromSession(HttpSession session){
        return (String)session.getAttribute("username");
    }

}
