package com.segway.s;

import android.os.RemoteException;
import android.util.Log;

/**
 * @author No.47 create at 2017/11/13.
 */
public class Maker extends IMaker.Stub {
    private final String TAG = getClass().getSimpleName();

    @Override
    public void setName(String name) throws RemoteException {
        Log.d(TAG, name);
    }
}
