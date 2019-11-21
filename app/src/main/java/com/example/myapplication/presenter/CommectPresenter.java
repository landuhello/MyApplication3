package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.CommentBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class CommectPresenter extends BasePresenter<MomInteface.docommect> {
     public void docomment(Map<String,String> map, Map<String,String> id, Map<String,Integer> pc){
         HttpUils.getHttpUils().docommect(map, id, pc, new HttpUils.CallBack<CommentBean>() {
             @Override
             public void success(CommentBean commentBean) {
                 getT().success(commentBean);
             }
         });
     }
}
