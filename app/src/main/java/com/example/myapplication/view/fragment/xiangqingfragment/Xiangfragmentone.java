package com.example.myapplication.view.fragment.xiangqingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.StickBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Xiangfragmentone extends Fragment {
    @BindView(R.id.xiangqing_dizhi)
    TextView xiangqingDizhi;
    Unbinder unbinder;
    private String address;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.xianglayoutone, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        EventBus.getDefault().register(this);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();

    }
    @Subscribe(threadMode = ThreadMode.ASYNC,sticky = true)
    public void dosticky(StickBean stickBean){
        address = stickBean.getAddress();

    }
    private void initview() {
    xiangqingDizhi.setText(address);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
