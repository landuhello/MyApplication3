package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.FeedbackBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class FeedPresenter extends BasePresenter<MomInteface.dofeed> {
     public void dofeed(Map<String,String> map, String content){
         HttpUils.getHttpUils().dofeed(map, content, new HttpUils.CallBack<FeedbackBean>() {

             @Override
             public void success(FeedbackBean bean) {
                 getT().success(bean);
             }
         });
     }
}
