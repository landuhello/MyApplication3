package com.example.myapplication.view.fragment.xiangqingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.presenter.AllcinPresenter;
import com.example.myapplication.view.activity.Main3Activity;
import com.example.myapplication.view.adapter.Fragmenttwoxiangtwoadapter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Xiangfragmenttwo extends Fragment implements MomInteface.doallcin {
    @BindView(R.id.xiangtwo_recy)
    RecyclerView xiangtwoRecy;
    Unbinder unbinder;
    @BindView(R.id.two_paiqi)
    Button twoPaiqi;
    private List<AllcimBean.ResultBean> result;
    private Fragmenttwoxiangtwoadapter fragmenttwoxiangtwoadapter;
    private int id;
    private AllcinPresenter allcinPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.xianglayouttwo, container, false);
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

    @Subscribe(threadMode = ThreadMode.BACKGROUND, sticky = true)
    public void donock(StickBean stickBean) {
        id = stickBean.getId();
        Log.i("io", id + "");
        allcinPresenter = new AllcinPresenter();
        allcinPresenter.bind(this);
        Map<String, Integer> map = new HashMap<>();
        map.put("page", 1);
        map.put("count", 10);
        allcinPresenter.doallcin(id, map);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initview() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        xiangtwoRecy.setLayoutManager(manager);
        fragmenttwoxiangtwoadapter = new Fragmenttwoxiangtwoadapter();
        xiangtwoRecy.setAdapter(fragmenttwoxiangtwoadapter);
    }

    @Subscribe
    @Override
    public void success(AllcimBean allcimBean) {
        result = allcimBean.getResult();
        fragmenttwoxiangtwoadapter.setResult(result);
        fragmenttwoxiangtwoadapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        allcinPresenter.unbind();

    }

    @OnClick(R.id.two_paiqi)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one_paiqi:
                startActivity(new Intent(getContext(), Main3Activity.class));
                break;
        }
    }
}
