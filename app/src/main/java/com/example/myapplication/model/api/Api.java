package com.example.myapplication.model.api;

import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.CindizhiBean;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.model.bean.QuyuchaxBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.ToolBean;
import com.example.myapplication.model.bean.ZhengBean;

import java.util.Map;


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

    //Banner
    @GET("tool/v2/banner")
    Observable<BannerBean> getBan();
    //正在热映
    @GET("movie/v2/findReleaseMovieList?page=1&count=12")
    Observable<ZhengBean> getzheng();
    //即将上映
    @GET("movie/v2/findComingSoonMovieList?page=1&count=3")
    Observable<JiBean> getji();
    //热门上映
    @GET("movie/v2/findHotMovieList?page=1&count=12")
    Observable<RmenBean> getrmen();
    //查询电影详情
    @GET("movie/v2/findMoviesDetail")
    Observable<DetilBean> Detail(@Query("movieId") int movieId);
    //查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<ToolBean> dotool();
    //区域查询电影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<QuyuchaxBean> doquyuchax (@Query("regionId") int regionId);
}
