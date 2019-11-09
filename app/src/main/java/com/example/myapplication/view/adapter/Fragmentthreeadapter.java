package com.example.myapplication.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmentthreeadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fraglist;

    public Fragmentthreeadapter(FragmentManager fm, ArrayList<Fragment> fraglist) {
        super(fm);
        this.fraglist = fraglist;
    }

    @Override
    public Fragment getItem(int i) {
        return fraglist.get(i);
    }

    @Override
    public int getCount() {
        return fraglist.size();
    }
}
