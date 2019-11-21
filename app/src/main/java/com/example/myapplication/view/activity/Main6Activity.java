package com.example.myapplication.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.greendao.DaoBeanDao;
import com.example.myapplication.greendao.DaoMaster;
import com.example.myapplication.greendao.DaoSession;
import com.example.myapplication.model.bean.DaoBean;
import com.example.myapplication.model.bean.EventBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.model.http.EncryptUtil;
import com.example.myapplication.presenter.LoginPresenter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main6Activity extends BaseActivity<LoginPresenter> implements MomInteface.dologin {
    @BindView(R.id.iv_deng)
    ImageView ivDeng;
    @BindView(R.id.ed_login)
    EditText edLogin;
    @BindView(R.id.ed_mima)
    EditText edMima;
    @BindView(R.id.but_wang)
    Button butWang;
    @BindView(R.id.tv_zhu)
    TextView tvZhu;
    @BindView(R.id.but_deng)
    Button butDeng;
    @BindView(R.id.wx_login)
    LinearLayout wxLogin;
    private String mima;
    private String login;
    private DaoBeanDao daoBeanDao;
    private String mi;
    private String email;
    private int userId;
    private String sessionId;

    @Override
    protected int initview() {
        return R.layout.activity_main6;
    }

    @Override
    protected LoginPresenter setpresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initdata() {
        SharedPreferences bw = getSharedPreferences("bw", MODE_MULTI_PROCESS);
        SharedPreferences.Editor edit = bw.edit();

        edit.putInt("login",userId);
        edit.putString("mima",sessionId);
        edit.commit();
    }

    @Override
    public void success(LoginBean bean) {
        if (bean != null && "0000".equals(bean.getStatus())) {
            startActivity(new Intent(this, Main2Activity.class));
            userId = bean.getResult().getUserId();
            sessionId = bean.getResult().getSessionId();
            Log.i("login","userId:"+ userId +"sessionId"+ sessionId);
            email = bean.getResult().getUserInfo().getEmail();
            mima = edMima.getText().toString().trim();
            mi = EncryptUtil.encrypt(mima);
            EventBus.getDefault().postSticky(bean);
        } else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick({R.id.ed_login, R.id.ed_mima, R.id.but_wang, R.id.tv_zhu, R.id.but_deng, R.id.wx_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_wang:
                startActivity(new Intent(this, Main8Activity.class));
                break;
            case R.id.tv_zhu:
                startActivity(new Intent(this, Main7Activity.class));
                break;
            case R.id.but_deng:
                login = edLogin.getText().toString().trim();
                mima = edMima.getText().toString().trim();
                if (TextUtils.isEmpty(login) || TextUtils.isEmpty(mima)) {
                    Toast.makeText(this, "输入为空", Toast.LENGTH_SHORT).show();
                } else {
                    mi = EncryptUtil.encrypt(mima);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("email", login);
                    map.put("pwd", mi);
                    t.dologin(map);
                    Log.i("pwd","密码是："+mi);
                }
                break;
            case R.id.wx_login:
                break;
        }
    }
}