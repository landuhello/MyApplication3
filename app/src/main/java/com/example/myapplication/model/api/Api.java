package com.example.myapplication.model.api;

import com.example.myapplication.model.bean.LoginBean;

import java.util.Map;

import javax.net.ssl.SSLServerSocket;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public interface Api {
    //登录
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> dologin(@FieldMap Map<String, String> map);


}
