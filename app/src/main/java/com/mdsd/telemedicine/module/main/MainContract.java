package com.mdsd.telemedicine.module.main;


import com.mdsd.telemedicine.base.BasePresenter;
import com.mdsd.telemedicine.base.BaseView;

/**
 * Created by Harrison.Pan on 2017/4/20.
 */

public class MainContract {

    public interface View extends BaseView<Presenter> {
        void showPatientSelector();

        void showChatPage();
    }

    public interface Presenter extends BasePresenter {
        void start();

        void selectPatient();

        void showChat();
    }
}
