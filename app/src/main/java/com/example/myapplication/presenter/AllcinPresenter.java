package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class AllcinPresenter extends BasePresenter<MomInteface.doallcin> {
     public void doallcin(int cinemaId, Map<String,Integer> map){
         HttpUils.getHttpUils().getall(cinemaId, map, new HttpUils.CallBack<AllcimBean>() {

             @Override
             public void success(AllcimBean allcimBean) {
                 getT().success(allcimBean);
             }
         });

     }
}
