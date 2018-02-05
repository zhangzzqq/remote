package com.mdsd.telemedicine.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdsd.telemedicine.common.notification.INotification;
import com.mdsd.telemedicine.common.notification.ToastAudioNotification;


public abstract class BaseFragment extends Fragment implements IBaseFragment {

    private static final boolean DEBUG = false;
    private INotification notification;

    public INotification getNotification() {
        return notification;
    }

    @Override
    public void onVisible() {
    }

    @Override
    public void onInvisible() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notification = new ToastAudioNotification(getContext());
        parseIntent();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    protected void parseIntent() {
    }

}
