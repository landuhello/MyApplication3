package com.example.myapplication.view.fragment.threeyingfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.ZhengBean;
import com.example.myapplication.presenter.BannerPresenter;
import com.example.myapplication.view.adapter.ReyingtwoAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Fragmentyingtwo extends BaseFragment<BannerPresenter> implements MomInteface.IBanner {

    @BindView(R.id.recy_ji)
    RecyclerView recyJi;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private ReyingtwoAdapter reyingtwoAdapter;

    @Override
    protected void initData() {
        f.setJi();
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyJi.setLayoutManager(linearLayoutManager);
        reyingtwoAdapter = new ReyingtwoAdapter(getContext());
        recyJi.setAdapter(reyingtwoAdapter);
    }

    @Override
    protected BannerPresenter setFrag() {
        return new BannerPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_fragmentyingtwo;
    }

    @Override
    public void ok(BannerBean bannerBean) {

    }

    @Override
    public void no(String mag) {

    }

    @Override
    public void rey(ZhengBean zhengBean) {

    }

    @Override
    public void reyji(JiBean jiBean) {
        List<JiBean.ResultBean> result = jiBean.getResult();
        reyingtwoAdapter.getyingji(result);
    }

    @Override
    public void remen(RmenBean rmenBean) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
