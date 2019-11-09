package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class NearPresenter extends BasePresenter<MomInteface.donear> {
     public void donear(Map<String,String> map, Map<String,Integer>nearmap){
         HttpUils.getHttpUils().getnear(map, nearmap, new HttpUils.CallBack<NearbyBean>() {

             @Override
             public void success(NearbyBean nearbyBean) {
                 getT().success(nearbyBean);
             }
         });
     }
}
