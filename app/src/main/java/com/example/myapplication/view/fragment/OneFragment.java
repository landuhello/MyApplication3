package com.example.myapplication.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.ZhengBean;
import com.example.myapplication.presenter.BannerPresenter;
import com.example.myapplication.view.activity.GengduoActivity;
import com.example.myapplication.view.activity.Main2Activity;
import com.example.myapplication.view.activity.MainActivity;
import com.example.myapplication.view.adapter.ReOneAdapter;
import com.example.myapplication.view.adapter.ReThreeAdapter;
import com.example.myapplication.view.adapter.ReTwoAdapter;
import com.example.myapplication.view.inteface.MomInteface;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class OneFragment extends BaseFragment<BannerPresenter> implements MomInteface.IBanner {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.tv_bei)
    TextView tvBei;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.rin1)
    RelativeLayout rin1;
    @BindView(R.id.tv_sansi)
    TextView tvSansi;
    @BindView(R.id.iv_zheng)
    ImageView ivZheng;
    @BindView(R.id.tv_zheng)
    TextView tvZheng;
    @BindView(R.id.tv_geng)
    TextView tvGeng;
    @BindView(R.id.lin)
    RelativeLayout lin;
    @BindView(R.id.re_one)
    RecyclerView reOne;
    @BindView(R.id.iv_ji)
    ImageView ivJi;
    @BindView(R.id.tv_ji)
    TextView tvJi;
    @BindView(R.id.tv_gengone)
    TextView tvGengone;
    @BindView(R.id.lin1)
    RelativeLayout lin1;
    @BindView(R.id.re_two)
    RecyclerView reTwo;
    @BindView(R.id.iv_ren)
    ImageView ivRen;
    @BindView(R.id.tv_ren)
    TextView tvRen;
    @BindView(R.id.tv_gengtwo)
    TextView tvGengtwo;
    @BindView(R.id.lin3)
    RelativeLayout lin3;
    @BindView(R.id.re_three)
    RecyclerView reThree;
    @BindView(R.id.lin2)
    LinearLayout lin2;
    @BindView(R.id.li)
    LinearLayout li;
    Unbinder unbinder;
    @BindView(R.id.ban)
    Banner ban;
    private LinearLayoutManager linearLayoutManager;
    private ReOneAdapter reOneAdapter;
    private LinearLayoutManager linearLayoutManager1;
    private ReTwoAdapter reTwoAdapter;
    private LinearLayoutManager linearLayoutManager2;
    private ReThreeAdapter reThreeAdapter;


    @Override
    protected void initData() {
        f.setBanner();
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        reOne.setLayoutManager(linearLayoutManager);
        reOneAdapter = new ReOneAdapter(getActivity());
        reOne.setAdapter(reOneAdapter);

        linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        reTwo.setLayoutManager(linearLayoutManager1);
        reTwoAdapter = new ReTwoAdapter(getContext());
        reTwo.setAdapter(reTwoAdapter);

        linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        reThree.setLayoutManager(linearLayoutManager2);
        reThreeAdapter = new ReThreeAdapter(getContext());
        reThree.setAdapter(reThreeAdapter);

        tvGeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),GengduoActivity.class));
            }
        });

    }

    @Override
    protected BannerPresenter setFrag() {
        return new BannerPresenter();
    }


    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragmentmoveone;
    }

    @Override
    public void ok(BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        ban.setImages(result);
        ban.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.ResultBean resultBean = (BannerBean.ResultBean) path;
                Glide.with(getActivity()).load(resultBean.getImageUrl()).into(imageView);
            }
        });
        ban.isAutoPlay(true);
        ban.setDelayTime(3000);
        ban.start();
        ban.setBannerAnimation(com.youth.banner.Transformer.Accordion);
        f.setZheng();
    }

    @Override
    public void no(String mag) {

    }

    @Override
    public void rey(ZhengBean zhengBean) {
        List<ZhengBean.ResultBean> result = zhengBean.getResult();
        reOneAdapter.getad(result);
        f.setJi();
    }

    @Override
    public void reyji(JiBean jiBean) {
        List<JiBean.ResultBean> result = jiBean.getResult();
        reTwoAdapter.getDa(result);
        f.setRmen();
    }

    @Override
    public void remen(RmenBean rmenBean) {
        List<RmenBean.ResultBean> result = rmenBean.getResult();
        reThreeAdapter.getDat(result);
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
