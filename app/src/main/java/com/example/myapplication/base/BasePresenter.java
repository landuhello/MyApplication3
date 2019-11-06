package com.example.myapplication.base;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class BasePresenter<T extends Baseinteface> {
     private T t;
     public void bind(T t){
         this.t=t;
     }
     public void unbind(){
         t=null;
     }

    public T getT() {
        return t;
    }
}
