package com.example.myapplication.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */
@Entity
public class DaoBean {
    @Id(autoincrement = true)
    private Long id;
    private String email;
    private String pwd;
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1142056450)
    public DaoBean(Long id, String email, String pwd) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
    }
    @Generated(hash = 405743142)
    public DaoBean() {
    }


}
