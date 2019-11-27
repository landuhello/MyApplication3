package com.example.myapplication.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView tv_yin;
    private int time = 2;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (time <= 0) {
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                    finish();
                } else {
                    time--;
                    tv_yin.setText(time + "");
                    handler.sendEmptyMessageDelayed(1, 1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_yin = findViewById(R.id.tv_yin);

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                handler.sendMessageDelayed(message, 1000);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);

    }

    public void yind(View view) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }
}
