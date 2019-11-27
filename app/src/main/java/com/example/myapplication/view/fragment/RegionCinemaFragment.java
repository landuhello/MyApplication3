package com.example.myapplication.view.fragment;

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

import com.example.myapplication.R;
import com.example.myapplication.base.SyLinearLayoutManager;
import com.example.myapplication.model.bean.CinemaByRegionBean;
import com.example.myapplication.model.bean.RegionListBean;
import com.example.myapplication.presenter.ChaXuanQuPresenter;
import com.example.myapplication.view.activity.Choose_seatActivity;
import com.example.myapplication.view.adapter.RecyclerRegionAdapter;
import com.example.myapplication.view.adapter.RecyclerRegionCinemaAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegionCinemaFragment extends Fragment implements MomInteface.IRegionListView {

    Unbinder unbinder;
    @BindView(R.id.recycler_region)
    RecyclerView recyclerRegion;
    @BindView(R.id.recycler_region_cinema)
    RecyclerView recyclerRegionCinema;
    private ChaXuanQuPresenter chaXuanQuPresenter;
    //区域 集合
    private List<RegionListBean.ResultBean> result;
    //区域 适配器
    private RecyclerRegionAdapter recyclerRegionAdapter;
    //区域 影院适配器
    private RecyclerRegionCinemaAdapter recyclerRegionCinemaAdapter;
    //区域影院集合
    private List<CinemaByRegionBean.ResultBean> cinemaByRegionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_region_cinema,container, false);
        unbinder = ButterKnife.bind(this, inflate);
        chaXuanQuPresenter = new ChaXuanQuPresenter();
        chaXuanQuPresenter.regionList();
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //区域列表查询
    @Override
    public void regionSuccess(RegionListBean regionListBean) {
        Log.e("RegionList", regionListBean.getResult().get(0).getRegionName());
        result = regionListBean.getResult();
        //自适应布局
        SyLinearLayoutManager syLinearLayoutManager = new SyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerRegionAdapter = new RecyclerRegionAdapter(getContext());
        recyclerRegionAdapter.addData(result);
        recyclerRegion.setLayoutManager(syLinearLayoutManager);
        recyclerRegion.setAdapter(recyclerRegionAdapter);

        recyclerRegionAdapter.onItemClickListener(new RecyclerRegionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int regionId) {
                Log.e("regionId", regionId + "");
                chaXuanQuPresenter.cinemaByRegion(regionId);
            }
        });
    }


    //根据区域查询影院
    @Override
    public void cinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean) {
        cinemaByRegionList = cinemaByRegionBean.getResult();
        //自适应布局
        SyLinearLayoutManager syLinearLayoutManager = new SyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerRegionCinemaAdapter = new RecyclerRegionCinemaAdapter(getContext());
        recyclerRegionCinemaAdapter.addData(cinemaByRegionList);
        recyclerRegionCinema.setLayoutManager(syLinearLayoutManager);
        recyclerRegionCinema.setAdapter(recyclerRegionCinemaAdapter);

        recyclerRegionCinemaAdapter.onItemClickListener(new RecyclerRegionCinemaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int cinemaId) {
                Intent intent = new Intent(getContext(), Choose_seatActivity.class);
                intent.putExtra("cinemaId", cinemaId);
                startActivity(intent);
            }
        });
    }


}
