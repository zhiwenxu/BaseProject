package com.xzw.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xzw.base.app.App;

/**
 * Created by xuzw-pc on 2017/9/7.
 *
 */

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends AppCompatActivity{

    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        if(presenter != null){
            presenter.attach((V)this);
        }
        App.getApp().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.dettach();
        }
        App.getApp().removeActivity(this);
    }
    public abstract P initPresenter();
//    public abstract void initTitleView();

}
