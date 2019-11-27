package com.example.myapplication.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.greendao.DaoBeanDao;
import com.example.myapplication.greendao.DaoMaster;
import com.example.myapplication.greendao.DaoSession;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.presenter.LoginPresenter;
import com.example.myapplication.view.activity.Main10Activity;
import com.example.myapplication.view.activity.Main6Activity;
import com.example.myapplication.view.activity.Main9Activity;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    Unbinder unbinder;
    @BindView(R.id.myattent)
    LinearLayout myattent;
    @BindView(R.id.mymake)
    LinearLayout mymake;
    @BindView(R.id.mybuy)
    LinearLayout mybuy;
    @BindView(R.id.mylookmove)
    LinearLayout mylookmove;
    @BindView(R.id.mycomment)
    LinearLayout mycomment;
    @BindView(R.id.myider)
    LinearLayout myider;
    @BindView(R.id.myset)
    LinearLayout myset;
    private LoginPresenter loginPresenter;
    private DaoBeanDao daoBeanDao;
    private String login;
    private String mima;
    private String status;
    private int userId;
    private String sessionId;

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

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void dorl(LoginBean loginBean) {
        Glide.with(getContext()).load(loginBean.getResult().getUserInfo().getHeadPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imageQwe);
        textQweName.setText(loginBean.getResult().getUserInfo().getNickName());
        status = loginBean.getStatus();
        userId = loginBean.getResult().getUserId();
        sessionId = loginBean.getResult().getSessionId();
        Log.i("sessionId",sessionId);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void initview() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //个人页面点击跳转详情
    @OnClick({R.id.myattent, R.id.mymake, R.id.mybuy, R.id.mylookmove, R.id.mycomment, R.id.myider, R.id.myset,R.id.lin_lau})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myattent:
                break;
            case R.id.mymake:
                break;
            case R.id.mybuy:
                break;
            case R.id.mylookmove:
                break;
            case R.id.mycomment:
                if ("0000".equals(status)) {
                    //我对电影院的意见
                    startActivity(new Intent(getContext(), Main10Activity.class));

                } else {
                    startActivity(new Intent(getContext(), Main6Activity.class));
                }
                break;
            case R.id.myider:
                               break;
            case R.id.myset:

                break;
            case R.id.lin_lau:
                //个人详情信息页面
                if ("0000".equals(status)) {
                    startActivity(new Intent(getContext(), Main9Activity.class));
                } else {
                    startActivity(new Intent(getContext(), Main6Activity.class));
                }
                break;
        }
    }

}
