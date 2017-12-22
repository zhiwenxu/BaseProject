package com.xzw.base.example.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xzw.base.R;
import com.xzw.base.databinding.LoginActivityBinding;
import com.xzw.base.utils.LogUtil;

/**
 * mvvm实现框架---databinding的使用---动态更新+双向绑定
 * Created by draven.xu on 17/12/22.
 */

public class LoginActivity extends Activity {

    private UserBean mUserBean = new UserBean();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.login_activity);
        binding.setUser(mUserBean);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.e("用户名："+mUserBean.getUsername());
                LogUtil.e("密码:"+mUserBean.getPassword());
                mUserBean.setUsername("xzw");
                mUserBean.setPassword("123456");
            }
        });
    }
}
