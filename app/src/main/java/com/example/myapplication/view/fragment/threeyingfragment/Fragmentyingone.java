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
import com.example.myapplication.view.adapter.ReOneAdapter;
import com.example.myapplication.view.adapter.ReyingoneAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Fragmentyingone extends BaseFragment<BannerPresenter> implements MomInteface.IBanner {

    @BindView(R.id.recy_zheng)
    RecyclerView recyZheng;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private ReyingoneAdapter reyingoneAdapter;


    @Override
    protected void initData() {
        f.setZheng();
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyZheng.setLayoutManager(linearLayoutManager);
        reyingoneAdapter = new ReyingoneAdapter(getActivity());
        recyZheng.setAdapter(reyingoneAdapter);
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
        return R.layout.fragment_fragmentyingone;
    }

    @Override
    public void ok(BannerBean bannerBean) {

    }

    @Override
    public void no(String mag) {

    }

    @Override
    public void rey(ZhengBean zhengBean) {
        List<ZhengBean.ResultBean> result = zhengBean.getResult();
        reyingoneAdapter.getying(result);
    }

    @Override
    public void reyji(JiBean jiBean) {

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
