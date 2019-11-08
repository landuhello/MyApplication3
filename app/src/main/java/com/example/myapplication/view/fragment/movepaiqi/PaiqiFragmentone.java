package com.example.myapplication.view.fragment.movepaiqi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class PaiqiFragmentone extends Fragment implements MomInteface.dopaiqi {

    private List<PaiqiBean.ResultBean> result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.paiqilayoutone, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
    }

    private void initview() {

    }

    @Override
    public void success(PaiqiBean bean) {
        result = bean.getResult();

    }
}
