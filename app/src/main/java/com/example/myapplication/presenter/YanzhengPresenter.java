package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.YanzhengBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class YanzhengPresenter extends BasePresenter<MomInteface.doyan> {
     public void doyan(String email){
         HttpUils.getHttpUils().docode(email, new HttpUils.CallBack<YanzhengBean>() {

             @Override
             public void success(YanzhengBean bean) {
                 getT().success(bean);
             }
         });
     }
}
