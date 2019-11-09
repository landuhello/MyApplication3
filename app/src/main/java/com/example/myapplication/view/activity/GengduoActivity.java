package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.view.adapter.Fragmentthreeadapter;
import com.example.myapplication.view.adapter.Fragmenttwoadapter;
import com.example.myapplication.view.fragment.threeyingfragment.Fragmentyingone;
import com.example.myapplication.view.fragment.threeyingfragment.Fragmentyingthree;
import com.example.myapplication.view.fragment.threeyingfragment.Fragmentyingtwo;
import com.example.myapplication.view.fragment.twofragment.Fragmentone;
import com.example.myapplication.view.fragment.twofragment.Fragmentthree;
import com.example.myapplication.view.fragment.twofragment.Fragmenttwo;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GengduoActivity extends AppCompatActivity  {

    @BindView(R.id.iv_ding)
    ImageView ivDing;
    @BindView(R.id.tv_bei1)
    TextView tvBei1;
    @BindView(R.id.iv_sou)
    ImageView ivSou;
    @BindView(R.id.rin2)
    RelativeLayout rin2;
    @BindView(R.id.fragmentying_tab)
    TabLayout fragmentyingTab;
    @BindView(R.id.fragmentying_vp)
    ViewPager fragmentyingVp;
    private ArrayList<Fragment> fraglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gengduo);
        ButterKnife.bind(this);
        fraglist = new ArrayList<>();
        fraglist.add(new Fragmentyingone());
        fraglist.add(new Fragmentyingtwo());
        fraglist.add(new Fragmentyingthree());
        Fragmentthreeadapter fragmentthreeadapter = new Fragmentthreeadapter(getSupportFragmentManager(), fraglist);
        fragmentyingVp.setAdapter(fragmentthreeadapter);
        fragmentyingTab.setupWithViewPager(fragmentyingVp);
        fragmentyingTab.getTabAt(0).setText("正在热映");
        fragmentyingTab.getTabAt(1).setText("即将上映");
        fragmentyingTab.getTabAt(2).setText("热门电影");
    }


}
