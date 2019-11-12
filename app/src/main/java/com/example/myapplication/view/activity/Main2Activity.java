package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.FragmentAdapter;
import com.example.myapplication.view.fragment.OneFragment;
import com.example.myapplication.view.fragment.ThreeFragment;
import com.example.myapplication.view.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class  Main2Activity extends AppCompatActivity implements View.OnClickListener{


    @BindView(R.id.image_movei_dj)
    ImageView imageMoveiDj;
    @BindView(R.id.lin_movei)
    LinearLayout linMovei;
    @BindView(R.id.lay_one)
    LinearLayout layOne;
    @BindView(R.id.image_cinem_dj)
    ImageView imageCinemDj;
    @BindView(R.id.lin_cinem)
    LinearLayout linCinem;
    @BindView(R.id.lay_two)
    LinearLayout layTwo;
    @BindView(R.id.image_myy_dj)
    ImageView imageMyyDj;
    @BindView(R.id.lin_myy)
    LinearLayout linMyy;
    @BindView(R.id.lay_swe)
    LinearLayout laySwe;
    @BindView(R.id.vp)
    CustomViewPager vp;
    List<Fragment> list = new ArrayList<>();
    List<LinearLayout> llist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        llist.add(linMovei);
        llist.add(linCinem);
        llist.add(linMyy);
        vp.setScanScroll(false);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragmentAdapter);
        imageMoveiDj.setOnClickListener(this);
        imageCinemDj.setOnClickListener(this);
        imageMyyDj.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_movei_dj:
                imageMoveiDj.setVisibility(View.GONE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.VISIBLE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.GONE);
                vp.setCurrentItem(0);
                break;
            case R.id.image_cinem_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.GONE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.VISIBLE);
                linMyy.setVisibility(View.GONE);
                vp.setCurrentItem(1);
                break;
            case R.id.image_myy_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.GONE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.VISIBLE);
                vp.setCurrentItem(2);
                break;
        }
    }
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                System.exit(0);
            } else {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
