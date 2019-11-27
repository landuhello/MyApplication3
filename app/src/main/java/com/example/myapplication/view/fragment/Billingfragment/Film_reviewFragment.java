package com.example.myapplication.view.fragment.Billingfragment;

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
import com.example.myapplication.model.bean.FilmReviewBean;
import com.example.myapplication.presenter.FilPresenter;
import com.example.myapplication.view.adapter.film_review_adapter.Film_review_Adapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Film_reviewFragment extends Fragment implements MomInteface.IComment {

    @BindView(R.id.film_rec)
    RecyclerView filmRec;
    Unbinder unbinder;
    private List<FilmReviewBean.ResultBean> result;
    private FilPresenter filPresenter;
    private Film_review_Adapter film_review_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_film_review, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
    }

    private void initview() {
        filPresenter = new FilPresenter();
        filPresenter.bind(this);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.e("AAA", movieId + "");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("page",1);
        hashMap.put("count",10);
        filPresenter.setComment(movieId,hashMap);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        filmRec.setLayoutManager(linearLayoutManager);
        film_review_adapter = new Film_review_Adapter();
        filmRec.setAdapter(film_review_adapter);
    }

    @Override
    public void success(FilmReviewBean filmReviewBean) {
        result = filmReviewBean.getResult();
        film_review_adapter.setResult(result);
        film_review_adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        filPresenter.unbind();
    }
}