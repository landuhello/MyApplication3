package com.example.myapplication.model.api;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
//        XGPushConfig.enableOtherPush(getApplicationContext(), true);
//        XGPushConfig.setHuaweiDebug(true);
//        XGPushConfig.setMiPushAppId(getApplicationContext(), "d71d384497c51");
//        XGPushConfig.setMiPushAppKey(getApplicationContext(), "A44FJ9N7N9EY");
//        XGPushConfig.setMzPushAppId(this, "d71d384497c51");

//        XGPushConfig.setMzPushAppKey(this, "A44FJ9N7N9EY");
        initXGPush();
        }
    private void initXGPush(){
        XGPushConfig.enableDebug(this,true);
        XGPushManager.registerPush(this, new XGIOperateCallback() {
    @Override
    public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.e("TPush","注册成功，设备token为："+ data);
            }
    @Override
    public void onFail(Object data, int errCode,String msg) {
                Log.e("TPush","注册失败，错误码："+ errCode +",错误信息："+ msg);
            }
        });
        //设置账号
        XGPushManager.registerPush(getApplicationContext(),"XINGE");
        // 设置标签
        XGPushManager.setTag(this,"XINGE");
    }


}
