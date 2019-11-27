package com.example.myapplication.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.SeatleBean;
import com.example.myapplication.presenter.SeatlePresenter;
import com.example.myapplication.view.inteface.MomInteface;

public class Choose_seatActivity extends BaseActivity<SeatlePresenter> implements MomInteface.ISeate {

    @Override
    protected int initview() {
        return R.layout.activity_choose_seat;
    }

    @Override
    protected SeatlePresenter setpresenter() {
        return new SeatlePresenter();
    }

    @Override
    protected void initdata() {

    }

    @Override
    public void success(SeatleBean seatleBean) {

    }
}
