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
import com.example.myapplication.model.api.Api;
import com.example.myapplication.model.bean.CommentBean;
import com.example.myapplication.presenter.CommentPresenter;
import com.example.myapplication.view.activity.DetailActivity;
import com.example.myapplication.view.adapter.film_review_adapter.Film_review_Adapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Film_reviewFragment extends BaseFragment<CommentPresenter> implements MomInteface.IComment {
    @BindView(R.id.film_rec)
    RecyclerView filmRec;
    Unbinder unbinder;
    private Film_review_Adapter film_review_adapter;

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.e("AAA", movieId + "");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("page",1);
        hashMap.put("count",10);
        f.setComment(movieId,hashMap);
    }

    @Override
    protected CommentPresenter setFrag() {
        return new CommentPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_film_review;
    }

    @Override
    public void success(CommentBean commentBean) {
        List<CommentBean.ResultBean> filmList = commentBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        filmRec.setLayoutManager(linearLayoutManager);
        film_review_adapter = new Film_review_Adapter();
        filmRec.setAdapter(film_review_adapter);
        film_review_adapter.setFilmList(filmList);
        film_review_adapter.notifyDataSetChanged();
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