package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.KeywordsBean;
import com.example.myapplication.presenter.KeywordPresenter;
import com.example.myapplication.view.adapter.recyclerKeyAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<KeywordPresenter> implements MomInteface.dokey {


    @BindView(R.id.et_movie_thekeyword)
    EditText etMovieThekeyword;
    @BindView(R.id.iv_search_movie)
    ImageView ivSearchMovie;
    @BindView(R.id.recycler_thekeyword)
    RecyclerView recyclerThekeyword;
    @BindView(R.id.fanhui)
    ImageView fanhui;

    private List<KeywordsBean.ResultBean> result;
    private com.example.myapplication.view.adapter.recyclerKeyAdapter recyclerKeyAdapter;

    @Override
    protected int initview() {
        return R.layout.activity_search;
    }

    @Override
    protected KeywordPresenter setpresenter() {
        return new KeywordPresenter();
    }


    @Override
    protected void initdata() {
        etMovieThekeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = etMovieThekeyword.getText().toString().trim();
                Map<String, Integer> map = new HashMap<>();
                map.put("page", 1);
                map.put("count", 10);
                t.dokey(map, keyword);

            }
        });

    }

    @Override
    public void success(KeywordsBean bean) {
        if (bean.getMessage().equals("未查到相关电影")) {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        } else {
            result = bean.getResult();
            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerKeyAdapter = new recyclerKeyAdapter();
            recyclerKeyAdapter.setResult(result);
            recyclerThekeyword.setLayoutManager(manager);
            recyclerThekeyword.setAdapter(recyclerKeyAdapter);
        }
    }


    @OnClick(R.id.fanhui)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                SearchActivity.this.finish();
                break;
        }
    }
}
