package com.example.myapplication.view.adapter.billingadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class BillingAdapter extends FragmentPagerAdapter {
    private List<Fragment> billlist;

    public BillingAdapter(FragmentManager fm, List<Fragment> billlist) {
        super(fm);
        this.billlist = billlist;
    }

    @Override
    public Fragment getItem(int i) {
        return billlist.get(i);
    }

    @Override
    public int getCount() {
        return billlist.size();
    }
}
