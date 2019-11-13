package com.example.myapplication.model.http;

import android.widget.Toast;

import com.example.myapplication.model.api.Api;
import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.BannerBean;
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
import java.util.concurrent.TimeUnit;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HEAD;


/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class HttpUils {
     private static HttpUils httpUils=new HttpUils();
    private final Api api;
    public HttpUils() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://172.17.8.100/movieApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static HttpUils getHttpUils() {
        return httpUils;
    }
    //登录
    public void getLogin(Map<String, String> map, final CallBack callBack) {
        api.dologin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean bean) throws Exception {
                        callBack.success(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });


    }
    //即将上映
    public void getJi(final CallBack callBack){
        api.getji()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JiBean>() {
                    @Override
                    public void accept(JiBean jiBean) throws Exception {
                        callBack.success(jiBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
    //推荐影院
    public void getcin(Map<String,Integer>map, final CallBack callBack){
        api.docin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CinemaBean>() {
                    @Override
                    public void accept(CinemaBean cinemaBean) throws Exception {
                        callBack.success(cinemaBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
    //正在热映
    public void getZheng(final CallBack callBack){
        api.getzheng()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhengBean>() {
                    @Override
                    public void accept(ZhengBean zhengBean) throws Exception {
                        callBack.success(zhengBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
    //查询电影详情
    public void doDetail(int movieId, final CallBack callBack) {
        api.Detail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetilBean>() {
                    @Override
                    public void accept(DetilBean detilBean) throws Exception {
                        callBack.success(detilBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }
    //Banner
    public void getban(final CallBack callBack){
        api.getBan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        callBack.success(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
    //热门上映
    public void getRmen(final CallBack callBack){
        api.getrmen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RmenBean>() {
                    @Override
                    public void accept(RmenBean rmenBean) throws Exception {
                        callBack.success(rmenBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }
    //附近影院
    public void getnear(Map<String,String>map, Map<String,Integer>nearmap, final CallBack callBack) {
        api.donear(map, nearmap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NearbyBean>() {
                    @Override
                    public void accept(NearbyBean nearbyBean) throws Exception {
                        callBack.success(nearbyBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }
        //影院用户评论
        public void getall( int  cinemaId,Map<String,Integer> map,final CallBack Callback){
            api.doall(cinemaId, map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<AllcimBean>() {
                        @Override
                        public void accept(AllcimBean allcimBean) throws Exception {
                            Callback.success(allcimBean);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                        }
                    });
        }


            public void getpaiqi(int cinemaId, Map<String,Integer> map,final CallBack Callback){
                api.dopaiqi(cinemaId, map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<PaiqiBean>() {
                            @Override
                            public void accept(PaiqiBean paiqiBean) throws Exception {
                                Callback.success(paiqiBean);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
            }

    //查询区域列表
    public void dotool(final CallBack callBack){
        api.dotool()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ToolBean>() {
                    @Override
                    public void accept(ToolBean toolBean) throws Exception {
                        callBack.success(toolBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                       throwable.printStackTrace();
                    }
                });
    }

    //区域查询电影院列表
    public void doquyucx(int regionId, final CallBack callBack){
        api.doquyuchax(regionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<QuyuchaxBean>() {
                    @Override
                    public void accept(QuyuchaxBean quyuchaxBean) throws Exception {
                        callBack.success(quyuchaxBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
    public interface CallBack<A>{
        void success(A a);
    }

}
