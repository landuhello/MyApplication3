package com.example.myapplication.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.CinemadetailsBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.presenter.MovemxPresenter;
import com.example.myapplication.view.adapter.Xiangfragmentadapter;
import com.example.myapplication.view.fragment.xiangqingfragment.Xiangfragmentone;
import com.example.myapplication.view.fragment.xiangqingfragment.Xiangfragmenttwo;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MovexiangqingMainActivity extends AppCompatActivity implements MomInteface.domx {

    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;
    @BindView(R.id.xiangqing_text)
    TextView xiangqingText;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.yanjing)
    TextView yanjing;
    private MovemxPresenter movemxPresenter;


    private ArrayList<Fragment> list;
    private int id;

    private Unbinder bind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movexiangqing_main);
        bind = ButterKnife.bind(this);
        initview();
        list = new ArrayList<>();
        list.add(new Xiangfragmentone());
        list.add(new Xiangfragmenttwo());
        Xiangfragmentadapter xiangfragmentadapter = new Xiangfragmentadapter(getSupportFragmentManager(), list);
        xiangqingVp.setAdapter(xiangfragmentadapter);
        xiangqingTab.setupWithViewPager(xiangqingVp);
        xiangqingTab.getTabAt(0).setText("影院详情");
        xiangqingTab.getTabAt(1).setText("影院评价");


    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void dostic(StickBean stickBean) {


        id = stickBean.getId();
        movemxPresenter.domx(id);
        SharedPreferences sharedPreferences = getSharedPreferences("bw.db", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("id", id);
        edit.commit();
        Log.i("aaa", id + "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initview() {
        movemxPresenter = new MovemxPresenter();
        movemxPresenter.bind(this);
    }


    @OnClick(R.id.fanhui)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                MovexiangqingMainActivity.this.finish();
                break;
        }
    }

    @Override
    public void success(CinemadetailsBean bean) {
        CinemadetailsBean.ResultBean result = bean.getResult();
        String name = result.getName();
        String label = result.getLabel();
        xiangqingText.setText(name);
        yanjing.setText(label);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        movemxPresenter.unbind();
    }
}
