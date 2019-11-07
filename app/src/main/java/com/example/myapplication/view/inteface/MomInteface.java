package com.example.myapplication.view.inteface;

import com.example.myapplication.base.Baseinteface;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.ZhengBean;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public interface MomInteface  {
     //登陆
     interface dologin extends Baseinteface{
         void success(LoginBean bean);
     }
     //推荐影院
     interface docin extends Baseinteface{
         void success(CinemaBean bean);
     }
    interface IBanner extends Baseinteface{
        void ok(BannerBean bannerBean);
        void no(String mag);
        void rey(ZhengBean zhengBean);
        void reyji(JiBean jiBean);
        void remen(RmenBean rmenBean);
    }

}
