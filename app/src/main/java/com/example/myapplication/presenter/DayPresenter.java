package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.DayBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class DayPresenter extends BasePresenter<MomInteface.doday> {
     public void doday(){
         HttpUils.getHttpUils().doday(new HttpUils.CallBack<DayBean>() {

             @Override
             public void success(DayBean bean) {
                 getT().success(bean);
             }
         });
     }
}
