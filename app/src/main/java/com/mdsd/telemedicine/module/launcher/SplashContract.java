package com.mdsd.telemedicine.module.launcher;


import com.mdsd.telemedicine.base.BasePresenter;
import com.mdsd.telemedicine.base.BaseView;

/**
 * Created by Harrison.Pan on 2017/4/20.
 */

public class SplashContract {
    public interface View extends BaseView<Presenter> {
        boolean isActive();

        void showLogin();
    }

    public interface Presenter extends BasePresenter {
        void start();
    }
}
