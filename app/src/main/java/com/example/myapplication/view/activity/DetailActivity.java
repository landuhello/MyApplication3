package com.example.myapplication.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.presenter.DetailPresenter;
import com.example.myapplication.view.adapter.billingadapter.BillingAdapter;
import com.example.myapplication.view.fragment.Billingfragment.Advance_noticeFragment;
import com.example.myapplication.view.fragment.Billingfragment.Film_reviewFragment;
import com.example.myapplication.view.fragment.Billingfragment.IntroduceFragment;
import com.example.myapplication.view.fragment.Billingfragment.Stage_photoFragment;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    @BindView(R.id.tv_xiangguo)
    TextView tvXiangguo;
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
    private DetilBean.ResultBean result;
    private ArrayList<Fragment> billlist;

    @Override
    protected int initview() {
        return R.layout.activity_detail;
    }

    @Override
    protected DetailPresenter setpresenter() {
        return new DetailPresenter();
    }


    @Override
    protected void initdata() {
        //接收传值
        Intent it = getIntent();
        int movieId = it.getIntExtra("movieId", 0);
        Log.e("AAA", movieId + "");
        t.setdetcil(movieId);
        //fragment
        billlist = new ArrayList<>();
        billlist.add(new IntroduceFragment());
        billlist.add(new Advance_noticeFragment());
        billlist.add(new Stage_photoFragment());
        billlist.add(new Film_reviewFragment());
        BillingAdapter billingAdapter = new BillingAdapter(getSupportFragmentManager(), billlist);
        xiangVp.setAdapter(billingAdapter);
        xiangTab.setupWithViewPager(xiangVp);
        xiangTab.getTabAt(0).setText("介绍");
        xiangTab.getTabAt(1).setText("预告");
        xiangTab.getTabAt(2).setText("剧照");
        xiangTab.getTabAt(3).setText("影评");
    }

    @Override
    public void ok(DetilBean detilBean) {
        result = detilBean.result;
        Toast.makeText(this, result.name, Toast.LENGTH_SHORT).show();
        tvXiangone.setText(detilBean.result.score + "分" + "");
        tvXiangtwo.setText(detilBean.result.commentNum + "万条");
        tvXiangthree.setText(detilBean.result.name);
        tvXianglei.setText(detilBean.result.movieType);
        tvXiangbo.setText(detilBean.result.duration);

        Date date = new Date(detilBean.result.releaseTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String format = sdf.format(date);
        tvXiangtime.setText(format);
        tvXiangguo.setText(detilBean.result.placeOrigin);
        Glide.with(this).load(detilBean.result.imageUrl)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(ivXiangtwo);
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
}
