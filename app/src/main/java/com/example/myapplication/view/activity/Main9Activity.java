package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        ButterKnife.bind(this);
    }
}
