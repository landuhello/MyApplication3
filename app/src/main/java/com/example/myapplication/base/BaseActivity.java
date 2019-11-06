package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements Baseinteface {
    public T t;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initview());
        bind = ButterKnife.bind(this);
        t =setpresenter();
        t.bind(this);
        initdata();
    }
    protected abstract int initview();
    protected abstract T setpresenter();
    protected abstract void initdata();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.unbind();
        bind.unbind();
    }
}
