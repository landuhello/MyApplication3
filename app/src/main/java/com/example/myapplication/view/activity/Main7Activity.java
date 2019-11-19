package com.example.myapplication.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.RegBean;
import com.example.myapplication.model.bean.YanzhengBean;
import com.example.myapplication.model.http.EncryptUtil;
import com.example.myapplication.presenter.RegPresenter;
import com.example.myapplication.presenter.YanzhengPresenter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main7Activity extends BaseActivity<RegPresenter> implements MomInteface.doreg, MomInteface.doyan {


    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.ed_nickname)
    EditText edNickname;
    @BindView(R.id.ed_youxiang)
    EditText edYouxiang;
    @BindView(R.id.ed_mm)
    EditText edMm;
    @BindView(R.id.ed_zhu)
    EditText edZhu;
    @BindView(R.id.but_verificationcode)
    Button butVerificationcode;
    @BindView(R.id.lin1)
    LinearLayout lin1;
    @BindView(R.id.tv_deng)
    TextView tvDeng;
    @BindView(R.id.but_zhuce)
    Button butZhuce;
    private String name;
    private String email;
    private String mima;
    private String code;
    private YanzhengPresenter yanzhengPresenter;

    @Override
    protected int initview() {
        return R.layout.activity_main7;
    }

    @Override
    protected RegPresenter setpresenter() {
        return new RegPresenter();
    }

    @Override
    protected void initdata() {
        yanzhengPresenter = new YanzhengPresenter();
        yanzhengPresenter.bind(this);

    }

    @Override
    public void success(RegBean bean) {
        if (bean != null && "0000".equals(bean.getStatus())) {
            startActivity(new Intent(this, Main6Activity.class));
        }
    }

    @Override
    public void success(YanzhengBean bean) {
        if (bean.equals("0000") && bean != null) {
            Toast.makeText(this, "发送失败，请重新发送", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.fanhui, R.id.but_verificationcode, R.id.lin1, R.id.tv_deng, R.id.but_zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                Main7Activity.this.finish();
                break;
            case R.id.but_verificationcode:
                email = edYouxiang.getText().toString().trim();
                yanzhengPresenter.doyan(email);
                break;
            case R.id.but_zhuce:
                name = edNickname.getText().toString().trim();
                email = edYouxiang.getText().toString().trim();
                mima = edMm.getText().toString().trim();
                code = edZhu.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mima) || TextUtils.isEmpty(email
                ) || TextUtils.isEmpty(code)) {
                    Toast.makeText(this, "输入框为空", Toast.LENGTH_SHORT).show();
                } else {
                    String pwd = EncryptUtil.encrypt(mima);

                    t.doreg(name, pwd, email, code);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        yanzhengPresenter.unbind();
    }
}
