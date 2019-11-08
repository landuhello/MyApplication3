package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.view.adapter.Xiangfragmentadapter;
import com.example.myapplication.view.fragment.xiangqingfragment.Xiangfragmentone;
import com.example.myapplication.view.fragment.xiangqingfragment.Xiangfragmenttwo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovexiangqingMainActivity extends AppCompatActivity {

    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;
    @BindView(R.id.xiangqing_text)
    TextView xiangqingText;
    @BindView(R.id.fanhui)
    ImageView fanhui;


    private ArrayList<Fragment> list;
    private int id;
    private String name;
    private String address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movexiangqing_main);
        ButterKnife.bind(this);

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
        name = stickBean.getName();
        address = stickBean.getAddress();
        id = stickBean.getId();
        xiangqingText.setText(name);
        Log.i("aaa", name);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
