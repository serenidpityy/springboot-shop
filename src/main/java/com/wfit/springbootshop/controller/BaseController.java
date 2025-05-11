package com.wfit.springbootshop.controller;

import com.wfit.springbootshop.service.ex.*;
import com.wfit.springbootshop.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ExceptionHandler;

//控制层类的基类
public class BaseController {
    //状态成功的状态码
    public static final int OK = 200;
    public static final int Password_inconsistency = 201; //原密码和session中的密码不一致

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
        }else if(e instanceof InsertException){
            jsonResult.setState(5003);
            jsonResult.setMessage("插入时产生未知异常");
        }else if(e instanceof AccessDeniedException){
            jsonResult.setState(5004);
            jsonResult.setMessage("非法访问");
        }else if(e instanceof CartNotFoundException){
            jsonResult.setState(5005);
            jsonResult.setMessage("购物车数据未找到");
        }else if(e instanceof UpdateException){
            jsonResult.setState(5006);
            jsonResult.setMessage("插入时产生未知异常");
        }else if(e instanceof Exception){
            jsonResult.setState(5000);
            jsonResult.setMessage("产生未知异常");
        }
        return jsonResult;
    }

    protected final String getidFromSession(HttpSession session){
        return (String)session.getAttribute("id");
    }

    public final String getusernameFromSession(HttpSession session){
        return (String)session.getAttribute("username");
    }

    protected final String getpasswordFromSession(HttpSession session){
        return (String)session.getAttribute("password");
    }

    protected final void setidFromSession(HttpSession session,String id){
        session.setAttribute("id",id);
    }

    protected final void setusernameFromSession(HttpSession session,String username){
        session.setAttribute("username",username);
    }

    protected final void setpasswordFromSession(HttpSession session,String password){
        session.setAttribute("password",password);
    }








    protected final String getselleridFromSession(HttpSession session){
        return (String)session.getAttribute("sellerid");
    }

    public final String getsellernameFromSession(HttpSession session){
        return (String)session.getAttribute("sellername");
    }

    protected final String getsellerpasswordFromSession(HttpSession session){
        return (String)session.getAttribute("sellerpassword");
    }

    protected final void setselleridFromSession(HttpSession session,String sellerid){
        session.setAttribute("sellerid",sellerid);
    }

    protected final void setsellernameFromSession(HttpSession session,String sellername){
        session.setAttribute("sellername",sellername);
    }

    protected final void setsellerpasswordFromSession(HttpSession session,String sellerpassword){
        session.setAttribute("sellerpassword",sellerpassword);
    }



    protected final String getadidFromSession(HttpSession session){
        return (String)session.getAttribute("adid");
    }

    public final String getadnameFromSession(HttpSession session){
        return (String)session.getAttribute("adname");
    }

    protected final String getadpasswordFromSession(HttpSession session){
        return (String)session.getAttribute("adpassword");
    }

    protected final void setadidFromSession(HttpSession session,String adid){
        session.setAttribute("adid",adid);
    }

    protected final void setadnameFromSession(HttpSession session,String adname){
        session.setAttribute("adname",adname);
    }

    protected final void setadpasswordFromSession(HttpSession session,String adpassword){
        session.setAttribute("adpassword",adpassword);
    }


}
