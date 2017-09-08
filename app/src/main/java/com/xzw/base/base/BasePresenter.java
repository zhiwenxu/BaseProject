package com.xzw.base.base;



/**
 * Created by dmsoft on 2017/9/8.
 * P
 */

public abstract class BasePresenter<T> {
     public T mView;

    public void attach(T v){
        mView = v;
    }
    public void dettach(){
        mView = null;
    }

}
