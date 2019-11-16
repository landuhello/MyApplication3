package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.CinemadetailsBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class MovemxPresenter extends BasePresenter<MomInteface.domx> {
     public void domx(int cinemaId){
         HttpUils.getHttpUils().domx(cinemaId, new HttpUils.CallBack<CinemadetailsBean>() {

             @Override
             public void success(CinemadetailsBean bean) {
                 getT().success(bean);
             }
         });
     }
}
