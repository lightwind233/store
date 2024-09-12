package com.cy.store.util;

import java.io.Serializable;

/*工具类需要创建和获得内部数据*/

//json格式数据响应
public class JsonResult<E> implements Serializable {

    private Integer state;

    private String message;
    private E data;//用泛型代表各种类型的数据

    public JsonResult() {
    }
    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message=e.getMessage();
    }


    public JsonResult(Integer state, String message) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
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
