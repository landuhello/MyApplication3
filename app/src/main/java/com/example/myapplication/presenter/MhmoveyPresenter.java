package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.MhmoveyBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class MhmoveyPresenter extends BasePresenter<MomInteface.domhmovey> {
     public void domhmovey(Map<String,Integer> map, String cinemaName){
         HttpUils.getHttpUils().domhmovey(map, cinemaName, new HttpUils.CallBack<MhmoveyBean>() {

             @Override
             public void success(MhmoveyBean bean) {
                 getT().success(bean);
             }
         });
     }
}
