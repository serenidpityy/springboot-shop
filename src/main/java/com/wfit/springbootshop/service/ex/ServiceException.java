package com.wfit.springbootshop.service.ex;

//业务层异常的基类
public class ServiceException extends RuntimeException{
    //导入相关的函数 右键 -> Generate -> Override Methods  <-> Ctrl  + O
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
