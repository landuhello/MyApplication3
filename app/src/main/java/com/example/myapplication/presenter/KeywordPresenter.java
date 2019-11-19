package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.KeywordsBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class KeywordPresenter extends BasePresenter<MomInteface.dokey> {
     public void dokey(Map<String,Integer> map, String keyword){
         HttpUils.getHttpUils().dokey(map, keyword, new HttpUils.CallBack<KeywordsBean>() {
             @Override
             public void success(KeywordsBean bean) {
                 getT().success(bean);
             }
         });
     }
}
