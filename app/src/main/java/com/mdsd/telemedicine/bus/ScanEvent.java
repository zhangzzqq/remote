package com.mdsd.telemedicine.bus;

import android.support.annotation.NonNull;

/**
 * Created by Harrison.Pan on 2016/11/16.
 * 扫码事件
 */
public class ScanEvent {
    private final String data;

    public ScanEvent(String data) {
        this.data = data;
    }

    @NonNull
    public final String getData() {
        return this.data == null ? "" : data.replaceAll("\t|\r|\n","");
    }
}
