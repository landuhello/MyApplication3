package com.example.myapplication.model.bean;

import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class DayBean {
    /**
     * result : ["11-13","11-14","11-15","11-16","11-17","11-18","11-19"]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<String> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
