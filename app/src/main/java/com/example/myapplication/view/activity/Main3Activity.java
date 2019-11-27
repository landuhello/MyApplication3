package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.DayBean;
import com.example.myapplication.presenter.DayPresenter;
import com.example.myapplication.view.adapter.PaiqiAdapter;
import com.example.myapplication.view.fragment.movepaiqi.PaiqiFragmentone;
import com.example.myapplication.view.fragment.movepaiqi.PaiqiFragmentthree;
import com.example.myapplication.view.fragment.movepaiqi.PaiqiFragmenttwo;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity implements MomInteface.doday {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.paiqi_tab)
    TabLayout paiqiTab;
    @BindView(R.id.paiqi_vp)
    ViewPager paiqiVp;
    private ArrayList<Fragment> list;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    private List<String> result = new ArrayList<>();
    private DayPresenter dayPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        initview();
    }

    private void initview() {
        dayPresenter = new DayPresenter();
        dayPresenter.bind(this);
        dayPresenter.doday();
        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//可选，设置定位模式，默认高精度
//LocationMode.Hight_Accuracy：高精度；
//LocationMode. Battery_Saving：低功耗；
//LocationMode. Device_Sensors：仅使用设备；

        option.setCoorType("bd09ll");
//可选，设置返回经纬度坐标类型，默认GCJ02
//GCJ02：国测局坐标；
//BD09ll：百度经纬度坐标；
//BD09：百度墨卡托坐标；
//海外地区定位，无需设置坐标类型，统一返回WGS84类型坐标

        option.setScanSpan(1000);
//可选，设置发起定位请求的间隔，int类型，单位ms
//如果设置为0，则代表单次定位，即仅定位一次，默认为0
//如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
//可选，设置是否使用gps，默认false
//使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
//可选，定位SDK内部是一个service，并放到了独立进程。
//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
//可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5 * 60 * 1000);
//可选，V7.2版本新增能力
//如果设置了该接口，首次启动定位时，会先判断当前Wi-Fi是否超出有效期，若超出有效期，会先重新扫描Wi-Fi，然后定位

        option.setEnableSimulateGps(false);
//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false

        mLocationClient.setLocOption(option);
//mLocationClient为第二步初始化过的LocationClient对象
//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
        list = new ArrayList<>();
        list.add(new PaiqiFragmentone(1));
        list.add(new PaiqiFragmentone(2));
        list.add(new PaiqiFragmentone(3));
        list.add(new PaiqiFragmentone(4));
        list.add(new PaiqiFragmentone(5));
        list.add(new PaiqiFragmentone(6));
        list.add(new PaiqiFragmentone(7));
        /*list.add(new PaiqiFragmenttwo());
        list.add(new PaiqiFragmentthree());*/
        PaiqiAdapter paiqiAdapter = new PaiqiAdapter(getSupportFragmentManager(), list);
        paiqiVp.setAdapter(paiqiAdapter);
        paiqiTab.setupWithViewPager(paiqiVp);

       /* paiqiTab.getTabAt(0).setText("今天");
        paiqiTab.getTabAt(1).setText("明天");
        paiqiTab.getTabAt(2).setText("后天");*/
    }


    @OnClick(R.id.fanhui)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                Main3Activity.this.finish();
                break;
        }
    }

    @Override
    public void success(DayBean bean) {
        result = bean.getResult();
        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            paiqiTab.getTabAt(i).setText(s);

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dayPresenter.unbind();
    }
}

