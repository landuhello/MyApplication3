package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.PaiqiAdapter;
import com.example.myapplication.view.fragment.movepaiqi.PaiqiFragmentone;
import com.example.myapplication.view.fragment.movepaiqi.PaiqiFragmentthree;
import com.example.myapplication.view.fragment.movepaiqi.PaiqiFragmenttwo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        list = new ArrayList<>();
        list.add(new PaiqiFragmentone());
        list.add(new PaiqiFragmenttwo());
        list.add(new PaiqiFragmentthree());
        PaiqiAdapter paiqiAdapter = new PaiqiAdapter(getSupportFragmentManager(), list);
        paiqiVp.setAdapter(paiqiAdapter);
        paiqiTab.setupWithViewPager(paiqiVp);
        paiqiTab.getTabAt(0).setText("今天");
        paiqiTab.getTabAt(1).setText("明天");
        paiqiTab.getTabAt(2).setText("后天");
    }
}
