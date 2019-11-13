package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.QuyuchaxBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class QuyuchaxPresenter extends BasePresenter<MomInteface.doquyucx> {
     public void doquyucx(int regionId){
         HttpUils.getHttpUils().doquyucx(regionId, new HttpUils.CallBack<QuyuchaxBean>() {

             @Override
             public void success(QuyuchaxBean bean) {
                 getT().success(bean);
             }
         });
     }
}
