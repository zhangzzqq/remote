package com.mdsd.telemedicine.module.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mdsd.telemedicine.BR;


/**
 * Created by Harrison.Pan on 2017/4/24.
 */

public class LoginViewModel extends BaseObservable {
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
