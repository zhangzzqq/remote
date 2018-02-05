package com.mdsd.telemedicine.module.login;


import com.mdsd.telemedicine.base.BasePresenter;
import com.mdsd.telemedicine.base.BaseView;

/**
 * Created by Harrison.Pan on 2017/4/20.
 */

public class LoginContract {
    public interface View extends BaseView<Presenter> {
        boolean isActive();

        void gotoMainActivity();
    }

    public interface Presenter extends BasePresenter {
        void start();

        void login(String username, String password);
    }
}
