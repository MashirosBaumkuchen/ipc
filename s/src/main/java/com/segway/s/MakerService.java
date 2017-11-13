package com.segway.s;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author No.47 create at 2017/11/13.
 */
public class MakerService extends Service {
    private IMaker.Stub maker = new Maker();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return maker;
    }
}
