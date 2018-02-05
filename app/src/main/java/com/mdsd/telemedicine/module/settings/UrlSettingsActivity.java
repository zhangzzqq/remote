package com.mdsd.telemedicine.module.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.base.AppBaseActivity;
import com.mdsd.telemedicine.utils.ActivityUtils;


public class UrlSettingsActivity extends AppBaseActivity {

    public static final String KEY_SHOULD_LOAD_URL = "KEY_SHOULD_LOAD";
    private UrlSettingsPresenter mUrlSettingsPresenter;
    private AlertDialog mDialog;


    public static final void start(Context context) {
        Intent intent = new Intent(context, UrlSettingsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_url);
        setupActionBar();

        UrlSettingsFragment urlSettingsFragment =
                (UrlSettingsFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (urlSettingsFragment == null) {
            urlSettingsFragment = UrlSettingsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), urlSettingsFragment, R.id.contentFrame);
        }
        boolean shouldLoadUrl = true;
        if (savedInstanceState != null) {
            shouldLoadUrl = savedInstanceState.getBoolean(KEY_SHOULD_LOAD_URL);
        }
        mUrlSettingsPresenter = new UrlSettingsPresenter(urlSettingsFragment, shouldLoadUrl);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(KEY_SHOULD_LOAD_URL, mUrlSettingsPresenter.isUrlMissing());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                performGoBack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void performGoBack() {
        if (mUrlSettingsPresenter.isUrlChanged()) {
            if (mDialog == null) {
                mDialog = new AlertDialog.Builder(this).setMessage(R.string.prompt_server_address_not_saved)
                        .setPositiveButton(R.string.button_save, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                UrlSettingsActivity.this.finish();
                            }
                        })
                        .setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                UrlSettingsActivity.this.finish();
                            }
                        }).create();
            }
            if (!mDialog.isShowing()) {
                mDialog.show();
            }
        } else {
            finish();
        }
    }

    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.title_activity_settings_url);
        ab.setDisplayHomeAsUpEnabled(true);
    }

}

