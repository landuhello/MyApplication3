package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class LoginPresenter extends BasePresenter<MomInteface.dologin> {
     public void dologin(Map<String,String>map){
         HttpUils.getHttpUils().getLogin(map, new HttpUils.CallBack<LoginBean>() {

             @Override
             public void success(LoginBean bean) {
                 getT().success(bean);
             }
         });

     }
}
