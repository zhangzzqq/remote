package com.mdsd.telemedicine.common.notification;

import android.content.Context;
import android.widget.Toast;

import com.mdsd.telemedicine.common.audio.AudioNotificationHelper;


/**
 * Created by Harrison.Pan on 2016/10/20.
 */
public class ToastAudioNotification implements INotification {
    private Toast toast;
    private Context mContext;

    public ToastAudioNotification(Context context) {
        this.mContext = context;
    }

    @Override
    public void showError(String error) {
        showToast(error);
        AudioNotificationHelper.getInstance().playWarn();
    }

    @Override
    public void showWarning(String warning) {
        showToast(warning);
        AudioNotificationHelper.getInstance().playWarn();
    }

    @Override
    public void showInfo(String info) {
        showToast(info);
        AudioNotificationHelper.getInstance().playInfo();
    }

    private void showToast(String content) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
        toast.setText(content);
        toast.show();
    }
}
