package com.xzw.base.app;

import android.app.Application;

import com.xzw.base.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzw-pc on 2017/9/7.
 *
 */

public class App extends Application{

    private static App app;
    private static List<BaseActivity> mActivitys = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public void addActivity(BaseActivity activity){
        if(activity != null){
            mActivitys.add(activity);
        }
    }

    public void removeActivity(BaseActivity activity){
        if(activity != null && mActivitys.contains(activity)){
            mActivitys.remove(activity);
        }
    }

    public static App getApp(){
        return app;
    }

    public static void exitApp(){
        for(BaseActivity activity : mActivitys){
            activity.finish();
        }
        mActivitys.clear();
        mActivitys = null;
        app = null;
    }

}
