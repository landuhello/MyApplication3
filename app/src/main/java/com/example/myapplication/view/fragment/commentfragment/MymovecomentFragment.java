package com.example.myapplication.view.fragment.commentfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.CommentBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.presenter.CommectPresenter;
import com.example.myapplication.view.inteface.MomInteface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class MymovecomentFragment extends Fragment implements MomInteface.docommect {
    @BindView(R.id.mymovehouse_recy)
    RecyclerView mymovehouseRecy;
    Unbinder unbinder;
    private CommectPresenter commectPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.mymovecomentlayout, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();

    }

    private void initview() {
        commectPresenter = new CommectPresenter();
        commectPresenter.bind(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND,sticky = true)
    public void success(LoginBean loginBean){
        int userId = loginBean.getResult().getUserId();
        String sessionId = loginBean.getResult().getSessionId();
        Map<String,String> map=new HashMap<>();
        map.put("userId",String.valueOf(userId));
        map.put("sessionId",sessionId);
        Map<String,String>id=new HashMap<>();
        id.put("longitude","0");
        id.put("latitude","0");
        Map<String,Integer>pc=new HashMap<>();
        pc.put("page",1);
        pc.put("count",5);
        commectPresenter.docomment(map,id,pc);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void success(CommentBean commentBean) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        commectPresenter.unbind();
    }
}