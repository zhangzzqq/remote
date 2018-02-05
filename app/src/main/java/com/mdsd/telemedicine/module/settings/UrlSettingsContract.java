package com.mdsd.telemedicine.module.settings;


import com.mdsd.telemedicine.base.BasePresenter;
import com.mdsd.telemedicine.base.BaseView;

/**
 * Created by Harrison.Pan on 2017/4/20.
 */

public class UrlSettingsContract {
    public interface View extends BaseView<Presenter> {
        boolean isActive();

        void setUrl(String url);

        void showToast(int resId);

        void showDoneMenu(boolean show);
    }

    public interface Presenter extends BasePresenter {
        void start();

        void onUrlTextChanged(CharSequence s);

        void test();

        void saveUrl(String url);

        boolean isUrlMissing();

        boolean isUrlChanged();
    }

}
