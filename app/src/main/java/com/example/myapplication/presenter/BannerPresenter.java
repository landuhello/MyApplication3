package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.ZhengBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;


public class BannerPresenter extends BasePresenter<MomInteface.IBanner> {
    //Banner
    public void setBanner(){
        HttpUils.getHttpUils().getban(new HttpUils.CallBack<BannerBean>() {
            @Override
            public void success(BannerBean bannerBean) {
                getT().ok(bannerBean);
            }
        });
    }
    //正在热映
    public void setZheng(){
        HttpUils.getHttpUils().getZheng(new HttpUils.CallBack<ZhengBean>() {
            @Override
            public void success(ZhengBean zhengBean) {
                getT().rey(zhengBean);
            }
        });
    }
    //即将上映
    public void setJi(){
         HttpUils.getHttpUils().getJi(new HttpUils.CallBack<JiBean>() {
             @Override
             public void success(JiBean jiBean) {
                 getT().reyji(jiBean);
             }
         });
    }
    //热门电影
    public void setRmen(){
        HttpUils.getHttpUils().getRmen(new HttpUils.CallBack<RmenBean>() {
            @Override
            public void success(RmenBean rmenBean) {
                getT().remen(rmenBean);
            }
        });
    }

}
