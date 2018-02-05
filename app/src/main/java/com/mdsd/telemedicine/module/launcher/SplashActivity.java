package com.mdsd.telemedicine.module.launcher;


import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.base.AppBaseActivity;
import com.mdsd.telemedicine.databinding.SplashActivityBinding;
import com.mdsd.telemedicine.module.login.LoginActivity;

public class SplashActivity extends AppBaseActivity implements SplashContract.View {
    private SplashActivityBinding binding;
    private boolean mActive = false;
    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        new SplashPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActive = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        mActive = false;
        super.onStop();
    }

    @Override
    public boolean isActive() {
        return this.mActive;
    }

    @Override
    public void showLogin() {
        LoginActivity.start(this);
        this.finish();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
