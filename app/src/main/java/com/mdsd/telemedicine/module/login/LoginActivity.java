package com.mdsd.telemedicine.module.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.base.AppBaseActivity;
import com.mdsd.telemedicine.databinding.LoginActivityBinding;
import com.mdsd.telemedicine.utils.ActivityUtils;


public class LoginActivity extends AppBaseActivity {
    private LoginActivityBinding binding;
    private LoginPresenter loginPresenter;

    public static final void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        setupToolbar();

        LoginFragment tasksFragment =
                (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            tasksFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }
        tasksFragment.setViewModel(new LoginViewModel());
        loginPresenter = new LoginPresenter(tasksFragment);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.title_activity_login);
    }

}

