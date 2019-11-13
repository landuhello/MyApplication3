package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.ToolBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class ToolPresenter extends BasePresenter<MomInteface.dotool> {
     public void dotool(){
         HttpUils.getHttpUils().dotool(new HttpUils.CallBack<ToolBean>() {
             @Override
             public void success(ToolBean toolBean) {
                 getT().success(toolBean);
             }
         });
     }
}
