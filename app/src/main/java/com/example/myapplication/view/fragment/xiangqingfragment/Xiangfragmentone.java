package com.example.myapplication.view.fragment.xiangqingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.CinemadetailsBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.presenter.MovemxPresenter;
import com.example.myapplication.view.activity.Main3Activity;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Xiangfragmentone extends Fragment implements MomInteface.domx {
    @BindView(R.id.xiangqing_dizhi)
    TextView xiangqingDizhi;
    Unbinder unbinder;
    @BindView(R.id.one_paiqi)
    Button onePaiqi;
    @BindView(R.id.xiangqing_phone)
    TextView xiangqingPhone;
    @BindView(R.id.xiangqing_luxian)
    TextView xiangqingLuxian;
    private String address;
    private MovemxPresenter movemxPresenter;
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.xianglayoutone, container, false);
        unbinder = ButterKnife.bind(this, inflate);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void dosticky(StickBean stickBean) {
        address = stickBean.getAddress();
        id = stickBean.getId();
        movemxPresenter.domx(id);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initview() {
        movemxPresenter = new MovemxPresenter();
        movemxPresenter.bind(this);

    }


    @OnClick(R.id.one_paiqi)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one_paiqi:
                startActivity(new Intent(getContext(), Main3Activity.class));
                break;
        }

    }

    @Override
    public void success(CinemadetailsBean bean) {
        CinemadetailsBean.ResultBean result = bean.getResult();
        xiangqingDizhi.setText(result.getAddress());
        xiangqingPhone.setText(result.getPhone());
        xiangqingLuxian.setText(result.getVehicleRoute());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        movemxPresenter.unbind();

    }
}
