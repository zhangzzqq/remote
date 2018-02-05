package com.mdsd.telemedicine.common.audio;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.RawRes;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.service.AudioService;


/**
 * Created by Harrison.Pan on 2016/10/20.
 */
public class ResourceAudioNotification extends AudioNotification {

    @RawRes
    private int mWarnResId = R.raw.warning;
    @RawRes
    private int mNoticeResId = -1;

    private Context mContext;

    public ResourceAudioNotification(Context context) {
        this.mContext = context;
    }

    @Override
    protected boolean performPlayWarn() {
        if (mWarnResId > 0) {
            play(mWarnResId);
            return true;
        }
        return false;
    }

    @Override
    protected boolean performPlayInfo() {
        if (mNoticeResId > 0) {
            play(mNoticeResId);
            return true;
        }
        return false;
    }

    public int getWarnResId() {
        return mWarnResId;
    }

    public void setWarnResId(int warnResId) {
        this.mWarnResId = warnResId;
    }

    public int getNoticeResId() {
        return mNoticeResId;
    }

    public void setNoticeResId(int noticeResId) {
        this.mNoticeResId = noticeResId;
    }

    private void play(int resId) {
        Intent intent = new Intent(mContext, AudioService.class);
        intent.putExtra(AudioService.KEY_RADIO_RES_ID, resId);
        mContext.startService(intent);
    }

    public static class Builder {
        private int mWarnResId = R.raw.warning;
        private int mNoticeResId = -1;
        private Context context;

        public Builder setWarnResId(int warnResId) {
            this.mNoticeResId = warnResId;
            return this;
        }

        public Builder setNoticeResId(int noticeResId) {
            this.mNoticeResId = noticeResId;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public AudioNotification build() {
            ResourceAudioNotification notification = new ResourceAudioNotification(context);
            notification.setWarnResId(mWarnResId);
            notification.setNoticeResId(mNoticeResId);
            return notification;
        }
    }
}
