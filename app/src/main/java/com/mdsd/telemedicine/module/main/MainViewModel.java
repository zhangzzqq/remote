package com.mdsd.telemedicine.module.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;

/**
 * Created by panxb on 27/04/17.
 */

public class MainViewModel extends BaseObservable {
    private Context mContext;
    private ObservableInt currentFunction = new ObservableInt(0);

    public MainViewModel(Context context) {
        this.mContext = context;
    }

    @Bindable
    public int getCurrentFunction() {
        return currentFunction.get();
    }

    public void setCurrentFunction(int currentFunction) {
        this.currentFunction.set(currentFunction);
    }
}
