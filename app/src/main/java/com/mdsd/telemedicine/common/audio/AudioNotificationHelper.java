package com.mdsd.telemedicine.common.audio;

/**
 * Created by Harrison.Pan on 2016/10/20.
 */
public class AudioNotificationHelper extends AudioNotification {
    private static AudioNotificationHelper instance;

    private AudioNotificationHelper() {
        AudioNotification successor = new FileAudioNotification.Builder().build();
        successor.setSuccessor(new ResourceAudioNotification.Builder().build());
        setSuccessor(successor);
    }

    public static AudioNotificationHelper getInstance() {
        if (instance == null) {
            synchronized (AudioNotificationHelper.class) {
                if (instance == null) {
                    instance = new AudioNotificationHelper();
                }
            }
        }
        return instance;
    }

    @Override
    protected boolean performPlayWarn() {
        return false;
    }

    @Override
    protected boolean performPlayInfo() {
        return false;
    }
}
