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
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.presenter.CinPresenter;
import com.example.myapplication.view.adapter.Fragmentoneadapter;
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
 * */public class Fragmentone extends Fragment implements MomInteface.docin {
    @BindView(R.id.fragmentone_recy)
    RecyclerView fragmentoneRecy;
    Unbinder unbinder;
    private CinPresenter cinPresenter;
    private List<CinemaBean.ResultBean> result;
    private Fragmentoneadapter fragmentoneadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentone, container, false);
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
        cinPresenter = new CinPresenter();
        cinPresenter.bind(this);
        Map<String,Integer>map=new HashMap<>();
        map.put("page",1);
        map.put("count",6);
        cinPresenter.docin(map);
    }
    private void initdata() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        fragmentoneRecy.setLayoutManager(manager);
        fragmentoneadapter = new Fragmentoneadapter();
        fragmentoneRecy.setAdapter(fragmentoneadapter);
    }

    @Override
    public void success(CinemaBean bean) {
        result = bean.getResult();
        fragmentoneadapter.setResult(result);
        fragmentoneadapter.notifyDataSetChanged();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        cinPresenter.unbind();
    }

}
