package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.LoginBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main9Activity extends AppCompatActivity {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.my_tou)
    ImageView myTou;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_sex)
    TextView mySex;
    @BindView(R.id.my_time)
    TextView myTime;
    @BindView(R.id.my_email)
    TextView myEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        ButterKnife.bind(this);
    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void dorl(LoginBean loginBean) {
        Glide.with(this).load(loginBean.getResult().getUserInfo().getHeadPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(myTou);
        myName.setText(loginBean.getResult().getUserInfo().getNickName());
        int sex = loginBean.getResult().getUserInfo().getSex();
        String Y;
        if (sex == 1) {
            Y = "男";
        } else {
            Y = "女";
        }
        mySex.setText(Y);
        myEmail.setText(loginBean.getResult().getUserInfo().getEmail());
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
