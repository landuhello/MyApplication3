package com.example.myapplication.view.fragment.movepaiqi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.model.bean.StickBean;
import com.example.myapplication.presenter.PaiqiPresenter;
import com.example.myapplication.view.adapter.FragmentpaiqiAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
 * */
@SuppressLint("ValidFragment")
public class PaiqiFragmentone extends Fragment implements MomInteface.dopaiqi {

    @BindView(R.id.paiqi)
    RecyclerView paiqi;
    Unbinder unbinder;
    private List<PaiqiBean.ResultBean> result;
    private PaiqiPresenter paiqiPresenter;

    private FragmentpaiqiAdapter fragmentpaiqiAdapter;
    private int id;
    int page;


    @SuppressLint("ValidFragment")
    public PaiqiFragmentone(int i) {
        this.page = i;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.paiqilayoutone, container, false);
        unbinder = ButterKnife.bind(this, inflate);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
    }

    private void initview() {
        //sp存值
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bw.db", Context.MODE_MULTI_PROCESS);
        id = sharedPreferences.getInt("id", 0);
        paiqiPresenter = new PaiqiPresenter();
        paiqiPresenter.bind(this);
        Map<String,Integer>map=new HashMap<>();
        map.put("page",page);
        map.put("count",10);
        paiqiPresenter.dopaiqi(id,map);
        Log.i("aaaa",id+"");
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        paiqi.setLayoutManager(manager);
        fragmentpaiqiAdapter = new FragmentpaiqiAdapter();
        paiqi.setAdapter(fragmentpaiqiAdapter);
    }

    @Override
    public void success(PaiqiBean bean) {
        result = bean.getResult();
        fragmentpaiqiAdapter.setResult(result);
        fragmentpaiqiAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        paiqiPresenter.unbind();
    }
}
