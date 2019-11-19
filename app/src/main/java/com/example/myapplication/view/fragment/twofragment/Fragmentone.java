package com.example.myapplication.view.fragment.twofragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.presenter.CinPresenter;
import com.example.myapplication.view.activity.MovexiangqingMainActivity;
import com.example.myapplication.view.adapter.Fragmentoneadapter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmentone extends Fragment implements MomInteface.docin {
    @BindView(R.id.fragmentone_recy)
    RecyclerView fragmentoneRecy;
    Unbinder unbinder;
    private CinPresenter cinPresenter;
    private List<CinemaBean.ResultBean> result;
    private Fragmentoneadapter fragmentoneadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentone, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        initdata();
    }


    private void initview() {
        cinPresenter = new CinPresenter();
        cinPresenter.bind(this);
        Map<String, Integer> map = new HashMap<>();
        map.put("page", 1);
        map.put("count", 6);
        cinPresenter.docin(map);
    }

    private void initdata() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        fragmentoneRecy.setLayoutManager(manager);
        fragmentoneadapter = new Fragmentoneadapter();
        fragmentoneRecy.setAdapter(fragmentoneadapter);

        fragmentoneadapter.setDomove(new Fragmentoneadapter.Domove() {

            private int id1;
            private String name1;
            private String address1;

            @Override
            public void onclick(String name, String address, int id, int i) {
                Intent intent = new Intent(getContext(), MovexiangqingMainActivity.class);
                startActivity(intent);
                address1 = result.get(i).getAddress();
                name1 = result.get(i).getName();
                id1 = result.get(i).getId();
                //传值
                EventBus.getDefault().postSticky(new StickBean(address1, name1, id1, null, null));
//                Log.i("hello",address1);
//                Log.i("hello1",name1);
//                Log.i("hello2",id1+"");
            }
        });
    }

    @Override
    public void success(CinemaBean bean) {
        result = bean.getResult();
        fragmentoneadapter.setResult(result);
        fragmentoneadapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        cinPresenter.unbind();
    }

}
