package com.segway.rpcdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author No.47 create at 2017/11/13.
 */
public class MyService extends Service {
    private IPlay.Stub play = new Play();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return play;
    }
}
