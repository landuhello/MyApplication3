package com.example.myapplication.view.fragment.Billingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.presenter.DetailPresenter;
import com.example.myapplication.view.adapter.billingadapter.DaoyanAdapter;
import com.example.myapplication.view.adapter.billingadapter.YanyuanAdapter;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class IntroduceFragment extends BaseFragment<DetailPresenter> implements MomInteface.IDetail {

    @BindView(R.id.tv_juqing)
    TextView tvJuqing;
    @BindView(R.id.tv_daoyin)
    TextView tvDaoyin;
    @BindView(R.id.item_daoyin_rec)
    RecyclerView itemDaoyinRec;
    @BindView(R.id.tv_yanyuan)
    TextView tvYanyuan;
    @BindView(R.id.item_yanyuan_rec)
    RecyclerView itemYanyuanRec;
    Unbinder unbinder;

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.e("AAA", movieId + "");
        f.setdetcil(movieId);
    }

    @Override
    protected DetailPresenter setFrag() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_introduce;
    }

    @Override
    public void ok(DetilBean detilBean) {
        DetilBean.ResultBean result = detilBean.result;
        tvJuqing.setText(detilBean.result.summary);
        tvDaoyin.setText("导演（"+detilBean.result.movieDirector.size()+")");

        List<DetilBean.ResultBean.MovieDirectorBean> movieDirector = detilBean.result.movieDirector;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        DaoyanAdapter daoyanAdapter = new DaoyanAdapter(movieDirector,getContext());
        itemDaoyinRec.setLayoutManager(linearLayoutManager);
        itemDaoyinRec.setAdapter(daoyanAdapter);

        tvYanyuan.setText("演员("+detilBean.result.movieActor.size()+")");
        List<DetilBean.ResultBean.MovieActorBean> movieActor = detilBean.result.movieActor;
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        YanyuanAdapter yanyuanAdapter = new YanyuanAdapter(movieActor,getContext());
        itemYanyuanRec.setLayoutManager(linearLayoutManager1);
        itemYanyuanRec.setAdapter(yanyuanAdapter);

    }

    @Override
    public void no(String msg) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
