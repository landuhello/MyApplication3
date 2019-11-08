package com.example.myapplication.model.api;

import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.bean.PaiqiBean;

import java.util.Map;

import javax.net.ssl.SSLServerSocket;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public interface Api {
    //登录
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> dologin(@FieldMap Map<String, String> map);
    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<CinemaBean> docin(@QueryMap Map<String,Integer> map);
    //附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<NearbyBean> donear(@QueryMap Map<String,String>map,@QueryMap Map<String,Integer>nearmap);
    //用户对影院的评论
    @GET("cinema/v1/findAllCinemaComment")
    Observable<AllcimBean> doall(@Query("cinemaId")int cinemaId,@QueryMap Map<String,Integer>map);
    //电影排期
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<PaiqiBean> dopaiqi(@Query("cinemaId")int cinemaId, @QueryMap Map<String,Integer>map);


}
