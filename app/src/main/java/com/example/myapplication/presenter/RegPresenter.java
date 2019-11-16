package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.RegBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class RegPresenter extends BasePresenter<MomInteface.doreg> {
     public void doreg(String nickName, String pwd, String email, String code){
         HttpUils.getHttpUils().doreg(nickName, pwd, email, code, new HttpUils.CallBack<RegBean>() {

             @Override
             public void success(RegBean bean) {
                 getT().success(bean);
             }
         });
     }
}
