package com.example.myapplication.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.greendao.DaoBeanDao;
import com.example.myapplication.greendao.DaoMaster;
import com.example.myapplication.greendao.DaoSession;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.presenter.LoginPresenter;
import com.example.myapplication.view.activity.Main2Activity;
import com.example.myapplication.view.activity.Main3Activity;
import com.example.myapplication.view.activity.Main4Activity;
import com.example.myapplication.view.activity.Main5Activity;
import com.example.myapplication.view.activity.Main6Activity;
import com.example.myapplication.view.activity.Main9Activity;
import com.example.myapplication.view.activity.MainActivity;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

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

    private LoginPresenter loginPresenter;
    private DaoBeanDao daoBeanDao;
    private String login;
    private String mima;
    private String status;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentmovetwo, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getContext(), "bw.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        daoBeanDao = daoSession.getDaoBeanDao();
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initview();
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void dorl(LoginBean loginBean){
        Glide.with(getContext()).load(loginBean.getResult().getUserInfo().getHeadPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imageQwe);
        textQweName.setText(loginBean.getResult().getUserInfo().getNickName());
        status = loginBean.getStatus();

    }
    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void initview() {

        linLau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("0000".equals(status)){
                    startActivity(new Intent(getContext(),Main9Activity.class));
                }else {
                    startActivity(new Intent(getContext(), Main6Activity.class));
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        loginPresenter.unbind();
    }


}
