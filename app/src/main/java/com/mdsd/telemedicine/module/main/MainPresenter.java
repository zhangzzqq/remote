package com.mdsd.telemedicine.module.main;

/**
 * Created by Harrison.Pan on 2017/4/26.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void selectPatient() {
        mView.showPatientSelector();
    }

    @Override
    public void showChat() {
        mView.showChatPage();
    }
}
