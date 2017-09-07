package com.xzw.base.app;

import android.app.Application;

import com.xzw.base.base.BaseActivity;
import com.xzw.base.base.BaseFragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzw-pc on 2017/9/7.
 *
 */

public class App extends Application{

    private App app;
    private List<BaseActivity> mActivitys = new ArrayList<>();
    private List<BaseFragmentActivity> mFragmentActivitys = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public App getApp(){
        return app;
    }

}
