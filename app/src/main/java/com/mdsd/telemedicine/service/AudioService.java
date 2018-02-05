package com.mdsd.telemedicine.service;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;


import com.mdsd.telemedicine.base.PersistentIntentService;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Harrison.Pan on 2016/10/19.
 */
public class AudioService extends PersistentIntentService implements SoundPool.OnLoadCompleteListener {
    public static final String KEY_RADIO_RES_ID = "radioResId";
    public static final String KEY_RADIO_SOURCE = "radioSource";
    public static final String KEY_RADIO_FILEPATH = "radioFilePath";

    public static final int RADIO_SOURCE_RAW = 1;
    public static final int RADIO_SOURCE_FILEPATH = 2;

    private static final float VOLUME_LEFT = 0.6f;
    private static final float VOLUME_RIGHT = 0.6f;

    private static final boolean DEBUG = Log.isLoggable("AudioService", Log.VERBOSE);
    private static final String TAG = AudioService.class.getName();
    private static final String SERVICE_NAME = AudioService.class.getSimpleName();
    private int lastResId = -1;
    private String lastFilepath = "";
    private int soundId = 1;
    private SoundPool mSoundPool;

    public AudioService() {
        super(SERVICE_NAME);
    }

    private SoundPool createSoundPool() {
        SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
        soundPool.setOnLoadCompleteListener(this);
        soundPool.setVolume(AudioManager.STREAM_MUSIC, VOLUME_LEFT, VOLUME_RIGHT);
        return soundPool;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onHandleIntent begin");
        }
        int source = intent.getIntExtra(KEY_RADIO_SOURCE, RADIO_SOURCE_RAW);
        switch (source) {
            case RADIO_SOURCE_RAW:
                int resId = intent.getIntExtra(KEY_RADIO_RES_ID, -1);
                if (resId > 0) {
                    if (lastResId == resId && soundId > 0) {
                        mSoundPool.play(soundId, VOLUME_LEFT, VOLUME_RIGHT, 0, 0, 1);
                    } else {
                        lastResId = resId;
                        lastFilepath = "";
                        if (mSoundPool != null) {
                            mSoundPool.release();
                        }
                        mSoundPool = createSoundPool();
                        mSoundPool.load(getApplicationContext(), resId, 1);
                    }
                }
                break;
            case RADIO_SOURCE_FILEPATH:
                String filepath = intent.getStringExtra(KEY_RADIO_FILEPATH);
                if (StringUtils.isNotEmpty(filepath)) {
                    if (StringUtils.equals(filepath, lastFilepath) && soundId > 0) {
                        mSoundPool.play(soundId, VOLUME_LEFT, VOLUME_RIGHT, 0, 0, 1);
                    } else {
                        lastFilepath = filepath;
                        lastResId = -1;
                        if (mSoundPool != null) {
                            mSoundPool.release();
                        }
                        mSoundPool = createSoundPool();
                        mSoundPool.load(filepath, 1);
                    }
                }
                break;
        }
        if (DEBUG) {
            Log.d(TAG, "onHandleIntent finished");
        }

    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        if (DEBUG) {
            Log.d(TAG, "onLoadComplete sampleId=" + sampleId + ", status=" + status);
        }
        if (status == 0) {
            soundPool.play(sampleId, VOLUME_LEFT, VOLUME_RIGHT, 0, 0, 1);
            soundId = sampleId;
        }
    }
}
