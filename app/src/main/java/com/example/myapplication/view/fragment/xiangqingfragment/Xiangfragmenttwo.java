package com.example.myapplication.view.fragment.xiangqingfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Xiangfragmenttwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.xianglayoutone, container, false);
        return inflate;
    }
}
