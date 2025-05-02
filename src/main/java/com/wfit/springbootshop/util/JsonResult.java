package com.wfit.springbootshop.util;
//Json格式的数据进行响应  使用泛型
public class JsonResult<E> {
    //状态码
    private int state;
    //描述信息
    private String message;
    //数据
    private E data;

    public JsonResult() {
    }

    public JsonResult(int state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(int state, E data) {
        this.state = state;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
