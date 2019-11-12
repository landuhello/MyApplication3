package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class ThreeFragment extends Fragment {
    @BindView(R.id.imag_xinxi)
    ImageView imagXinxi;
    @BindView(R.id.r_r)
    RelativeLayout rR;
    @BindView(R.id.image_qwe)
    ImageView imageQwe;
    @BindView(R.id.text_qwe_name)
    TextView textQweName;
    @BindView(R.id.imag_name_space)
    ImageView imagNameSpace;
    @BindView(R.id.lin_lau)
    LinearLayout linLau;
    @BindView(R.id.imag_movie_span)
    ImageView imagMovieSpan;
    @BindView(R.id.lin_lay)
    LinearLayout linLay;
    @BindView(R.id.line_attention)
    LinearLayout lineAttention;
    @BindView(R.id.line_subscribe)
    LinearLayout lineSubscribe;
    @BindView(R.id.line_ticket)
    LinearLayout lineTicket;
    @BindView(R.id.line_seek_movie)
    LinearLayout lineSeekMovie;
    @BindView(R.id.line_discuss)
    LinearLayout lineDiscuss;
    @BindView(R.id.line_tickling)
    LinearLayout lineTickling;
    @BindView(R.id.line_install)
    LinearLayout lineInstall;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentmovetwo, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
