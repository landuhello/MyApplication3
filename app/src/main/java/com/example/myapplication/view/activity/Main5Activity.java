package com.example.myapplication.view.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.MhmoveyBean;
import com.example.myapplication.presenter.MhmoveyPresenter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main5Activity extends AppCompatActivity implements MomInteface.domhmovey {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }


    @Override
    public void success(MhmoveyBean bean) {

    }
}
