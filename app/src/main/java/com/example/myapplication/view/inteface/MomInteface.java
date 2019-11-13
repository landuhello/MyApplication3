package com.example.myapplication.view.inteface;

import com.example.myapplication.base.Baseinteface;

import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.CindizhiBean;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.model.bean.QuyuchaxBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.ToolBean;
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
     //附近影院
    interface donear extends Baseinteface{
         void success(NearbyBean nearbyBean);
     }
     //影院评论
     interface doallcin extends Baseinteface{
         void success(AllcimBean allcimBean);
     }
     //影院排期
    interface dopaiqi extends Baseinteface{
         void success(PaiqiBean bean);
     }
    interface IBanner extends Baseinteface{
        void ok(BannerBean bannerBean);
        void no(String mag);
        void rey(ZhengBean zhengBean);
        void reyji(JiBean jiBean);
        void remen(RmenBean rmenBean);
    }
    //电影详情
    interface IDetail extends Baseinteface{
         void ok(DetilBean detilBean);
         void no(String msg);
    }
    //地址
    interface docindizhi extends Baseinteface{
         void success(CindizhiBean bean);
    }
    //查询区域列表
    interface dotool extends Baseinteface{
         void success(ToolBean toolBean);
    }
    //区域查询
    interface doquyucx extends Baseinteface{
         void success(QuyuchaxBean bean);
    }
}
