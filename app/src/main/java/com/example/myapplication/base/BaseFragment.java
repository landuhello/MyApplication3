package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public abstract class BaseFragment<F extends BasePresenter> extends Fragment implements Baseinteface {

    public F f;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(setLayout(), container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        bind = ButterKnife.bind(getActivity());
        f = setFrag();
        f.bind(this);
        initData();
    }

    protected abstract void initData();

    protected abstract F setFrag();

    protected abstract void initView();

    protected abstract  int setLayout();

    public <T extends View> T getViewId(int id){
        return getView().findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        f.unbind();
        bind.unbind();

    }
}
