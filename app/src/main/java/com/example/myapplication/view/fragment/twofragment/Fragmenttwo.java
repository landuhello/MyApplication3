package com.example.myapplication.view.fragment.twofragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.presenter.NearPresenter;
import com.example.myapplication.view.adapter.Fragmenttwofujinadapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmenttwo extends Fragment implements MomInteface.donear {
    @BindView(R.id.fragmenttwo_recy)
    RecyclerView fragmenttwoRecy;
    Unbinder unbinder;
    private NearPresenter nearPresenter;
    private List<NearbyBean.ResultBean> result;
    private Fragmenttwofujinadapter fragmenttwofujinadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmenttwo, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        initdata();
    }

    private void initview() {
        Map<String,String>map=new HashMap<>();
        map.put("longitude","116.30551391385724");
        map.put("latitude","40.04571807462411");
        Map<String,Integer>nearmap=new HashMap<>();
        nearmap.put("page",1);
        nearmap.put("count",10);
        nearPresenter = new NearPresenter();
        nearPresenter.bind(this);
        nearPresenter.donear(map,nearmap);
    }

    private void initdata() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        fragmenttwoRecy.setLayoutManager(manager);
        fragmenttwofujinadapter = new Fragmenttwofujinadapter();
        fragmenttwoRecy.setAdapter(fragmenttwofujinadapter);
    }
    @Override
    public void success(NearbyBean nearbyBean) {
        result = nearbyBean.getResult();
        fragmenttwofujinadapter.setResult(result);
        fragmenttwofujinadapter.notifyDataSetChanged();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        nearPresenter.unbind();
    }


}
