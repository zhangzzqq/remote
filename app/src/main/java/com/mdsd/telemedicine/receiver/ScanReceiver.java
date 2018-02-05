package com.mdsd.telemedicine.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.mdsd.telemedicine.bus.ScanEvent;


public class ScanReceiver extends BroadcastReceiver {

    /**
     * 东大集成Seuic AUTOID9 PDA扫码广播事件
     */
    private static final String ACTION_SCAN_SEUIC = "com.android.server.scannerservice.broadcast";
    /**
     * 东大集成Seuic AUTOID9 PDA扫码返回值的key
     */
    private static final String KEY_ACTION_SCAN_DATA_SEUIC = "scannerdata";

    /**
     * 目前用户：苏州九龙医院
     * 识凌科技BayNexus PDA扫码广播事件
     */
    private static final String ACTION_SCAN_BAYNEXUS = "SYSTEM_BAR_READ";
    /**
     * 识凌科技BayNexus PDA扫码广播事件返回值的key
     */
    private static final String KEY_ACTION_SCAN_DATA_BAYNEXUS = "BAR_VALUE";

    /**
     * LACHESIS PDA扫码广播事件
     */
    private static final String ACTION_SCAN_LACHESIS = "lachesis_barcode_value_notice_broadcast";
    /**
     * LACHESIS PDA扫码广播事件返回值的key
     */
    private static final String KEY_ACTION_SCAN_DATA_LACHESIS = "lachesis_barcode_value_notice_broadcast_data_string";

    @Override
    public void onReceive(Context context, Intent intent) {
        ScanEvent event = null;
        if (TextUtils.equals(ACTION_SCAN_SEUIC, intent.getAction())) {
            event = new ScanEvent(intent.getStringExtra(KEY_ACTION_SCAN_DATA_SEUIC));
        } else if (TextUtils.equals(ACTION_SCAN_BAYNEXUS, intent.getAction())) {
            event = new ScanEvent(intent.getStringExtra(KEY_ACTION_SCAN_DATA_BAYNEXUS));
        } else if (TextUtils.equals(ACTION_SCAN_LACHESIS, intent.getAction())) {
            event = new ScanEvent(intent.getStringExtra(KEY_ACTION_SCAN_DATA_LACHESIS));
        }
//        if (event != null) {
//            EventBus.getDefault().post(event);
//        }
    }
}
