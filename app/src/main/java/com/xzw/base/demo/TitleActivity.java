package com.xzw.base.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewConfiguration;

import com.xzw.base.R;
import com.xzw.base.base.BaseActivity;
import com.xzw.base.base.BasePresenter;
import com.xzw.base.callback.TitleBarClickListener;
import com.xzw.base.custom.TitleBar;


/**
 * Created by dmsoft on 2017/9/11.
 *
 */

public class TitleActivity extends BaseActivity implements TitleBarClickListener{

    private TitleBar mTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        init();
    }

    private void init(){
        mTitleBar = findViewById(R.id.title_bar);
        mTitleBar.setTitle("标题");
        mTitleBar.setRightImage(R.mipmap.ic_launcher_round);
        mTitleBar.setLeftTv("我的信息");
        mTitleBar.setOnTitleBarListener(this);
        int mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();


    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onTitleClick(int orientation) {
        switch (orientation){
            case TITLE_LEFT:
                Log.e("TAG","左边按钮");
                break;
            case TITLE_RIGHT:
                Log.e("TAG","右边按钮");
                break;
        }
    }
}
