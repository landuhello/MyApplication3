package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.CinemaByRegionBean;
import com.example.myapplication.model.bean.RegionListBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

public class ChaXuanQuPresenter extends BasePresenter<MomInteface.IRegionListView> {
    //查询区域列表
    public void regionList(){
        HttpUils.getHttpUils().regionList(new HttpUils.CallBack<RegionListBean>() {
            @Override
            public void success(RegionListBean regionListBean) {
                getT().regionSuccess(regionListBean);
            }

        });

    }

    //根据区域查询影院
    public void cinemaByRegion(int regionId){
       HttpUils.getHttpUils().cinemaByRegion(new HttpUils.CallBack<CinemaByRegionBean>() {
           @Override
           public void success(CinemaByRegionBean cinemaByRegionBean) {

           }
       },regionId);
    }
}
