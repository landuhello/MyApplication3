package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;

public class DetailPresenter extends BasePresenter<MomInteface.IDetail>{
    public void setdetcil(int movieId){
        HttpUils.getHttpUils().doDetail(movieId, new HttpUils.CallBack<DetilBean>() {
            @Override
            public void success(DetilBean detilBean) {
              getT().ok(detilBean);
            }


        });
    }
}
