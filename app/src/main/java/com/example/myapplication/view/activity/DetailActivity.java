package com.example.myapplication.view.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.bean.EventBean;
import com.example.myapplication.presenter.DetailPresenter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity<DetailPresenter> implements MomInteface.IDetail {

    @BindView(R.id.iv_xiangone)
    ImageView ivXiangone;
    @BindView(R.id.recy_xiang)
    RecyclerView recyXiang;
    @BindView(R.id.xiang_tab)
    TabLayout xiangTab;
    @BindView(R.id.xiang_vp)
    ViewPager xiangVp;
    @BindView(R.id.btn_xieyingpin)
    Button btnXieyingpin;
    @BindView(R.id.btn_xuanzuo)
    Button btnXuanzuo;
    private int movieId;
    public List<DetilBean.ResultBean> detaillist;

    @Override
    protected int initview() {
        return R.layout.activity_detail;
    }

    @Override
    protected DetailPresenter setpresenter() {
        return new DetailPresenter();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND, sticky = true)
    public void setEvent(EventBean eventBean) {
        movieId = eventBean.getMovieId();
        t.setdetcil(movieId);
        Log.e("ss", movieId + "");
    }

    @Override
    protected void initdata() {

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

    @Override
    public void ok(DetilBean detilBean) {
        DetilBean.ResultBean result = detilBean.result;


    }

    @Override
    public void no(String msg) {

    }
}
