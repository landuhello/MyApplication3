package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class CinPresenter extends BasePresenter<MomInteface.docin> {
     public void docin(Map<String,Integer>map){
         HttpUils.getHttpUils().getcin(map, new HttpUils.CallBack<CinemaBean>() {

             @Override
             public void success(CinemaBean bean) {
                 getT().success(bean);
             }
         });
     }
}
