package com.example.myapplication.model.bean;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class StickBean {
     public String address;
     public String name;
     public int id;

    public StickBean(String address, String name, int id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
