package com.example.myapplication.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.FragmentAdapter;
import com.example.myapplication.view.fragment.OneFragment;
import com.example.myapplication.view.fragment.ThreeFragment;
import com.example.myapplication.view.fragment.TwoFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager vp;
    private RadioButton rbut1;
    private RadioButton rbut2;
    private RadioButton rbut3;
    private RadioGroup rgoup;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();
    }

    private void initview() {
        initdata();
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(fragmentAdapter);
        rgoup.setOnCheckedChangeListener(this);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rgoup.check(rgoup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initdata() {

        vp = (ViewPager) findViewById(R.id.vp);
        rbut1 = (RadioButton) findViewById(R.id.rbut1);
        rbut2 = (RadioButton) findViewById(R.id.rbut2);
        rbut3 = (RadioButton) findViewById(R.id.rbut3);
        rgoup = (RadioGroup) findViewById(R.id.rgoup);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.rbut1:
                vp.setCurrentItem(0);
                break;
            case R.id.rbut2:
                vp.setCurrentItem(1);
                break;
            case R.id.rbut3:
                vp.setCurrentItem(2);
                break;
        }
    }
}
