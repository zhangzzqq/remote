package com.mdsd.telemedicine.module.launcher;

import android.os.Handler;

/**
 * Created by Harrison.Pan on 2017/4/20.
 */

public final class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;
    private static final Handler HANDLER = new Handler();

    public SplashPresenter(SplashContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.showLogin();
            }
        }, 1500);
    }
}
