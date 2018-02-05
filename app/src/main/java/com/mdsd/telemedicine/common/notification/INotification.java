package com.mdsd.telemedicine.common.notification;

/**
 * Created by Harrison.Pan on 2016/10/20.
 */
public interface INotification {
    void showError(String error);

    void showWarning(String warning);

    void showInfo(String info);
}
