package com.mdsd.telemedicine.common.audio;

import android.util.Log;

/**
 * Created by Harrison.Pan on 2016/10/20.
 */
public abstract class AudioNotification implements IAudioNotification {
    private static final String TAG = AudioNotification.class.getName();
    private static final boolean DEBUG = Log.isLoggable("Audio", Log.VERBOSE);
    private AudioNotification successor;
    private boolean mute = false;

    public AudioNotification getSuccessor() {
        return successor;
    }

    @SuppressWarnings("UnusedReturnValue")
    public AudioNotification setSuccessor(AudioNotification successor) {
        this.successor = successor;
        return this.successor;
    }

    @Override
    public final void playWarn() {
        if (DEBUG) {
            Log.d(TAG, this.getClass().getSimpleName() + "-->playWarn");
        }
        if (mute) {
            return;
        }
        if (!performPlayWarn()
                && successor != null) {
            successor.playWarn();
        }
    }

    @Override
    public final void playInfo() {
        if (DEBUG) {
            Log.d(TAG, this.getClass().getSimpleName() + "-->playNotice");
        }
        if (mute) {
            return;
        }
        if (!performPlayInfo()
                && successor != null) {
            successor.playInfo();
        }
    }

    public final boolean isMute() {
        return mute;
    }

    public final void setMute(boolean mute) {
        this.mute = mute;
    }

    public void toggle() {
        setMute(!isMute());
    }

    /**
     * 播放警告信息
     *
     * @return filtered
     */
    protected abstract boolean performPlayWarn();

    /**
     * 播放提示信息
     *
     * @return filtered
     */
    protected abstract boolean performPlayInfo();
}
