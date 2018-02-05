package com.mdsd.telemedicine.common.audio;

import android.content.Context;
import android.content.Intent;


import com.mdsd.telemedicine.service.AudioService;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Harrison.Pan on 2016/10/20.
 */
public class FileAudioNotification extends AudioNotification {

    private String mWarnFile;
    private String mNoticeFile;
    private Context mContext;

    public FileAudioNotification(Context context) {
        this.mContext = context;
    }

    @Override
    protected boolean performPlayWarn() {
        if (StringUtils.isNotEmpty(mWarnFile)) {
            play(mWarnFile);
            return true;
        }
        return false;
    }

    @Override
    protected boolean performPlayInfo() {
        if (StringUtils.isNotEmpty(mNoticeFile)) {
            play(mNoticeFile);
            return true;
        }
        return false;
    }

    private void play(String file) {
        Intent intent = new Intent(mContext, AudioService.class);
        intent.putExtra(AudioService.KEY_RADIO_SOURCE, AudioService.RADIO_SOURCE_FILEPATH);
        intent.putExtra(AudioService.KEY_RADIO_FILEPATH, file);
        mContext.startService(intent);
    }

    public String getWarnFile() {
        return mWarnFile;
    }

    public void setWarnFile(String warnFile) {
        this.mWarnFile = warnFile;
    }

    public String getNoticeFile() {
        return mNoticeFile;
    }

    public void setNoticeFile(String noticeFile) {
        this.mNoticeFile = noticeFile;
    }

    static class Builder {
        private String warnFile;
        private String noticeFile;
        private Context context;

        public Builder setWarnFile(String warnFile) {
            this.warnFile = warnFile;
            return this;
        }

        public Builder setNoticeFile(String noticeFile) {
            this.noticeFile = noticeFile;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public AudioNotification build() {
            FileAudioNotification fileAudioNotification = new FileAudioNotification(context);
            fileAudioNotification.setWarnFile(warnFile);
            fileAudioNotification.setNoticeFile(noticeFile);
            return fileAudioNotification;
        }
    }
}
