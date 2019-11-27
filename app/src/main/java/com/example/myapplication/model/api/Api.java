package com.example.myapplication.model.api;

import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.CinemaByRegionBean;
import com.example.myapplication.model.bean.CinemadetailsBean;
import com.example.myapplication.model.bean.CommentBean;
import com.example.myapplication.model.bean.DayBean;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.bean.FeedbackBean;
import com.example.myapplication.model.bean.FilmReviewBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.KeywordsBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.MhmoveyBean;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.model.bean.QuyuchaxBean;
import com.example.myapplication.model.bean.RegBean;
import com.example.myapplication.model.bean.RegionListBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.SeatleBean;
import com.example.myapplication.model.bean.ToolBean;
import com.example.myapplication.model.bean.YanzhengBean;
import com.example.myapplication.model.bean.ZhengBean;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
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
    //注册
    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<RegBean> doreg(@Field("nickName")String nickName, @Field("pwd") String pwd,
                              @Field("email")String email,
                              @Field("code")String code
                              );
    //发送验证码
    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<YanzhengBean> doyan(@Field("email")String email);
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
    //日期
    @GET("tool/v2/findDateList")
    Observable<DayBean> doday();
    //电影院明细
    @GET("cinema/v1/findCinemaInfo")
    Observable<CinemadetailsBean> domx(@Query("cinemaId")int cinemaId);
    //模糊查询电影院
    @GET("cinema/v1/findAllCinemas")
    Observable<MhmoveyBean> domhmovey(@QueryMap Map<String,Integer>map,@Query("cinemaName")String cinemaName);
    //评论
    @GET("movie/v2/findAllMovieComment?movieId=22&page=1&count=10")
    Observable<FilmReviewBean> getcomment(@Query("movieId") int movieId , @QueryMap Map<String,Integer> headMap);
    //查询区域列表
    @GET("tool2/findRegionList")
    Observable<RegionListBean> regionList();

    //根据区域查询影院
    @GET("cinema2/findCinemaByRegion")
    Observable<CinemaByRegionBean> cinemaByRegion(@Query("regionId") int regionId);

    //根据影厅id 查询座位信息
    @GET("movie/v2/findSeatInfo")
    Observable<SeatleBean> Seatle(@Query("hallId") int hallId);
    //根据电影关键字查找电影详情
    @GET("movie/v2/findMovieByKeyword")
    Observable<KeywordsBean> dokey(@QueryMap Map<String,Integer>map,@Query("keyword")String keyword);
    //查询影院评论
    @GET("user/v2/verify/findMyCinemaCommentList")
    Observable<CommentBean> docomment(@HeaderMap Map<String,String>map,@QueryMap Map<String,String> id,@QueryMap Map<String,Integer> pc);
    //意见反馈
    @FormUrlEncoded
    @POST("tool/v1/verify/recordFeedBack")
    Observable<FeedbackBean> dofeed(@FieldMap Map<String,String>map,@Field("content")String content);


}
