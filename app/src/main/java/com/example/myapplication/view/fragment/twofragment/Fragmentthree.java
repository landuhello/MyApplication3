package com.example.myapplication.view.fragment.twofragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.myapplication.model.bean.QuyuchaxBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.model.bean.ToolBean;
import com.example.myapplication.presenter.QuyuchaxPresenter;
import com.example.myapplication.presenter.ToolPresenter;
import com.example.myapplication.view.activity.MovexiangqingMainActivity;
import com.example.myapplication.view.adapter.Dizhiadapter;
import com.example.myapplication.view.adapter.Fragmentoneadapter;
import com.example.myapplication.view.adapter.Fragmenttwofujinadapter;
import com.example.myapplication.view.adapter.QuyucxAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmentthree extends Fragment implements MomInteface.dotool,MomInteface.doquyucx {
    @BindView(R.id.quyu_recy)
    RecyclerView quyuRecy;
    @BindView(R.id.dianyingquyu_recy)
    RecyclerView dianyingquyuRecy;
    Unbinder unbinder;
    private int id1;
    private List<ToolBean.ResultBean> result;

    private ToolPresenter toolPresenter;
    private Dizhiadapter dizhiadapter;
    private QuyuchaxPresenter quyuchaxPresenter;
    private List<QuyuchaxBean.ResultBean> result1=new ArrayList<>();
    private QuyucxAdapter quyucxAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentthree, container, false);
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
         toolPresenter = new ToolPresenter();
        toolPresenter.bind(this);
        toolPresenter.dotool();
        quyuchaxPresenter = new QuyuchaxPresenter();
        quyuchaxPresenter.bind(this);

    }

    private void initdata() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        quyuRecy.setLayoutManager(manager);
        dizhiadapter = new Dizhiadapter();
        quyuRecy.setAdapter(dizhiadapter);
        //点击
        dizhiadapter.setOnclicklisten(new Dizhiadapter.Onclicklisten() {

            private int regionId;


            @Override
            public void success(int id, int i) {
                regionId = result.get(i).getRegionId();
                quyuchaxPresenter.doquyucx(regionId);
            }
        });
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        dianyingquyuRecy.setLayoutManager(manager1);
        quyucxAdapter = new QuyucxAdapter();
        dianyingquyuRecy.setAdapter(quyucxAdapter);
        quyucxAdapter.setOnclicklisten(new QuyucxAdapter.Onclicklisten() {
            @Override
            public void success(int id, int i) {
                id1 = result1.get(i).getId();
                Intent intent = new Intent(getContext(), MovexiangqingMainActivity.class);
                startActivity(intent);
                EventBus.getDefault().postSticky(new StickBean(null,null,id1,null,null));
            }
        });

    }
    @Override
    public void success(ToolBean toolBean) {
        result = toolBean.getResult();
        dizhiadapter.setResult(result);
        dizhiadapter.notifyDataSetChanged();
    }



    @Override
    public void success(QuyuchaxBean bean) {
        result1 = bean.getResult();
        quyucxAdapter.clear();
        quyucxAdapter.setResult1(result1);
        quyucxAdapter.notifyDataSetChanged();

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        toolPresenter.unbind();
    }
}
