package com.xzw.base.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.xzw.base.BR;

/**
 * Created by draven.xu on 17/12/22.
 */

public class UserBean extends BaseObservable{

    private String username;
    private String password;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
