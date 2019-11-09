package com.example.myapplication.view.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.bean.EventBean;
import com.example.myapplication.presenter.DetailPresenter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity<DetailPresenter> implements MomInteface.IDetail {

    @BindView(R.id.iv_xiangone)
    ImageView ivXiangone;
    @BindView(R.id.iv_xiangtwo)
    ImageView ivXiangtwo;
    @BindView(R.id.tv_xiangone)
    TextView tvXiangone;
    @BindView(R.id.tv_xiangtwo)
    TextView tvXiangtwo;
    @BindView(R.id.tv_xiangthree)
    TextView tvXiangthree;
    @BindView(R.id.tv_xianglei)
    TextView tvXianglei;
    @BindView(R.id.tv_xiangbo)
    TextView tvXiangbo;
    @BindView(R.id.iv_xiangxin)
    ImageView ivXiangxin;
    @BindView(R.id.tv_xianggouan)
    TextView tvXianggouan;
    @BindView(R.id.iv_xiangyouxin)
    ImageView ivXiangyouxin;
    @BindView(R.id.tv_xiangyiguang)
    TextView tvXiangyiguang;
    @BindView(R.id.tv_xiangtime)
    TextView tvXiangtime;
    @BindView(R.id.rel_xiang)
    RelativeLayout relXiang;
    @BindView(R.id.xiang_tab)
    TabLayout xiangTab;
    @BindView(R.id.xiang_vp)
    ViewPager xiangVp;
    @BindView(R.id.btn_xieyingpin)
    Button btnXieyingpin;
    @BindView(R.id.btn_xuanzuo)
    Button btnXuanzuo;
    private int movieId;

    @Override
    protected int initview() {
        return R.layout.activity_detail;
    }

    @Override
    protected DetailPresenter setpresenter() {
        return new DetailPresenter();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND,sticky = true)
    public void setEvent(EventBean eventBean){
        movieId = eventBean.getMovieId();
        t.setdetcil(movieId);
    }

    @Override
    protected void initdata() {

    }

    @Override
    public void ok(DetilBean detilBean) {

    }

    @Override
    public void no(String msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
