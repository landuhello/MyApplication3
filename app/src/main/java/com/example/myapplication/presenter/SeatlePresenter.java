package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.SeatleBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

public class SeatlePresenter extends BasePresenter<MomInteface.ISeate> {
    public void setSeatle(int hallId){
        HttpUils.getHttpUils().doSeatle(hallId, new HttpUils.CallBack<SeatleBean>() {
            @Override
            public void success(SeatleBean seatleBean) {
                getT().success(seatleBean);
            }
        });
    }
}
