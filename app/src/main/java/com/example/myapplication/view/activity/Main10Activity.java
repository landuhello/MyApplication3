package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.Myhodseadapter;
import com.example.myapplication.view.fragment.commentfragment.MymovehouseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main10Activity extends AppCompatActivity {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.paiqi_tab)
    TabLayout paiqiTab;
    @BindView(R.id.paiqi_vp)
    ViewPager paiqiVp;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        list = new ArrayList<>();
        list.add(new MymovehouseFragment());
        list.add(new MymovehouseFragment());
        Myhodseadapter myhodseadapter = new Myhodseadapter(getSupportFragmentManager(), list);
        paiqiVp.setAdapter(myhodseadapter);
        paiqiTab.setupWithViewPager(paiqiVp);
        paiqiTab.getTabAt(0).setText("电影");
        paiqiTab.getTabAt(1).setText("影院");

    }

    @OnClick(R.id.fanhui)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.fanhui:
                Main10Activity.this.finish();
        }

    }
}
