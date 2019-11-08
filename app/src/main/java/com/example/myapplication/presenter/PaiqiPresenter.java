package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class PaiqiPresenter extends BasePresenter<MomInteface.dopaiqi> {
     public void dopaiqi(int cinemaId, Map<String,Integer> map){
         HttpUils.getHttpUils().getpaiqi(cinemaId, map, new HttpUils.CallBack<PaiqiBean>() {
             @Override
             public void success(PaiqiBean bean) {
                 getT().success(bean);
             }
         });
     }
}
