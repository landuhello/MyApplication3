package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.Xiangfragmentadapter;
import com.example.myapplication.view.fragment.xiangqingfragment.Xiangfragmentone;
import com.example.myapplication.view.fragment.xiangqingfragment.Xiangfragmenttwo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovexiangqingMainActivity extends AppCompatActivity {

    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;

    private ArrayList<Fragment> list;

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
}
