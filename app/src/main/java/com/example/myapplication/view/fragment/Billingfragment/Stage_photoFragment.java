package com.example.myapplication.view.fragment.Billingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.presenter.DetailPresenter;
import com.example.myapplication.view.adapter.stage_photo_Adapter.Stage_photo_Adapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Stage_photoFragment extends BaseFragment<DetailPresenter> implements MomInteface.IDetail {

    @BindView(R.id.stage_photo_rec)
    RecyclerView stagePhotoRec;
    Unbinder unbinder;

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.e("AAA", movieId + "");
        f.setdetcil(movieId);
    }

    @Override
    protected DetailPresenter setFrag() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_stage_photo;
    }

    @Override
    public void ok(DetilBean detilBean) {
        List<String> posterList = detilBean.result.posterList;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        Stage_photo_Adapter stage_photo_adapter = new Stage_photo_Adapter(posterList, getContext());
        stagePhotoRec.setLayoutManager(gridLayoutManager);
        stagePhotoRec.setAdapter(stage_photo_adapter);
    }

    @Override
    public void no(String msg) {

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
