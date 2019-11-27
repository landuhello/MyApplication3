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
import com.example.myapplication.model.bean.MhmoveyBean;
import com.example.myapplication.presenter.MhmoveyPresenter;
import com.example.myapplication.view.adapter.RecyclerKeyWordAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main5Activity extends BaseActivity<MhmoveyPresenter> implements MomInteface.domhmovey {


    @BindView(R.id.et_movie_thekeyword)
    EditText etMovieThekeyword;
    @BindView(R.id.iv_search_movie)
    ImageView ivSearchMovie;
    @BindView(R.id.recycler_thekeyword)
    RecyclerView recyclerThekeyword;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    private int page = 1;
    private int count = 5;
    private List<MhmoveyBean.ResultBean> result;
    private RecyclerKeyWordAdapter recyclerKeyWordAdapter;

    @Override
    protected int initview() {
        return R.layout.activity_main5;
    }

    @Override
    protected MhmoveyPresenter setpresenter() {
        return new MhmoveyPresenter();
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
                t.domhmovey(map, keyword);

            }
        });

    }

    @Override
    public void success(MhmoveyBean bean) {
        if (bean.getMessage().equals("未查到相关电影院")) {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        } else {
            result = bean.getResult();
            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerKeyWordAdapter = new RecyclerKeyWordAdapter();
            recyclerKeyWordAdapter.setResult(result);
            recyclerThekeyword.setLayoutManager(manager);
            recyclerThekeyword.setAdapter(recyclerKeyWordAdapter);
        }
    }


    @OnClick(R.id.fanhui)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                Main5Activity.this.finish();
                break;
        }
    }
}
