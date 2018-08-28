package com.mdsd.telemedicine.module.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.base.BaseFragment;
import com.mdsd.telemedicine.databinding.LoginFragmentBinding;
import com.mdsd.telemedicine.module.main.MainActivity;
import com.mdsd.telemedicine.module.settings.UrlSettingsActivity;


public class LoginFragment extends BaseFragment implements LoginContract.View {
    private LoginContract.Presenter mPresenter;
    private LoginFragmentBinding mLoginFragmentBinding;
    private LoginViewModel mLoginViewModel;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mLoginFragmentBinding == null) {
            mLoginFragmentBinding = LoginFragmentBinding.inflate(inflater, container, false);
        }
        mLoginFragmentBinding.setViewModel(mLoginViewModel);
        mLoginFragmentBinding.setActionHandler(mPresenter);
        setHasOptionsMenu(true);
        return mLoginFragmentBinding.getRoot();
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        inflater.inflate(R.menu.fragment_login_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings_url:
                UrlSettingsActivity.start(getActivity());
                return true;
        }
        return false;
    }

    public void setViewModel(LoginViewModel viewModel) {
        this.mLoginViewModel = viewModel;
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void gotoMainActivity() {

        MainActivity.start(getActivity());

        getActivity().finish();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
