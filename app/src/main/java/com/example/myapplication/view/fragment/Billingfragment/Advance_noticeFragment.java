package com.example.myapplication.view.fragment.Billingfragment;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.myapplication.view.adapter.advance_notice_adapter.Advance_notice_Adapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class Advance_noticeFragment extends BaseFragment<DetailPresenter> implements MomInteface.IDetail {
    @BindView(R.id.advance_rec)
    RecyclerView advanceRec;
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
        return R.layout.fragment_advance_notice;
    }

    @Override
    public void ok(DetilBean detilBean) {
        List<DetilBean.ResultBean.ShortFilmListBean> shortFilmList = detilBean.result.shortFilmList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Advance_notice_Adapter advance_notice_adapter = new Advance_notice_Adapter(shortFilmList, getContext());
        advanceRec.setLayoutManager(linearLayoutManager);
        advanceRec.setAdapter(advance_notice_adapter);
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

    @Override
    public void onStop() {
        super.onStop();
        JCVideoPlayerStandard.releaseAllVideos();
    }
}
