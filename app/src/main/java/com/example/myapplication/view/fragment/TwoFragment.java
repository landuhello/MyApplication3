package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.view.adapter.Fragmenttwoadapter;
import com.example.myapplication.view.fragment.twofragment.Fragmentone;
import com.example.myapplication.view.fragment.twofragment.Fragmentthree;
import com.example.myapplication.view.fragment.twofragment.Fragmenttwo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class TwoFragment extends Fragment {

    @BindView(R.id.fragmenttwo_tab)
    TabLayout fragmenttwoTab;
    @BindView(R.id.fragmenttwo_vp)
    ViewPager fragmenttwoVp;
    Unbinder unbinder;
    private ArrayList<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentmove, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
    }

    private void initview() {
        list = new ArrayList<>();
        list.add(new Fragmentone());
        list.add(new Fragmenttwo());
        list.add(new Fragmentthree());
        Fragmenttwoadapter fragmenttwoadapter = new Fragmenttwoadapter(getChildFragmentManager(), list);
        fragmenttwoVp.setAdapter(fragmenttwoadapter);
        fragmenttwoTab.setupWithViewPager(fragmenttwoVp);
        fragmenttwoTab.getTabAt(0).setText("推荐影院");
        fragmenttwoTab.getTabAt(1).setText("附近影院");
        fragmenttwoTab.getTabAt(2).setText("海淀区");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
