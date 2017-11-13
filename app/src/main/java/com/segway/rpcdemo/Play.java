package com.segway.rpcdemo;

import android.os.RemoteException;
import android.util.Log;

/**
 * @author No.47 create at 2017/11/13.
 */
public class Play extends IPlay.Stub {
    private final String TAG = getClass().getSimpleName();

    @Override
    public void setName(String name) throws RemoteException {
        Log.d(TAG,"setName");
    }

    @Override
    public void addFile(String f_name) throws RemoteException {
        Log.d(TAG,"addFile");
    }

    @Override
    public String ToString() throws RemoteException {
        Log.d(TAG,"ToString");
        return null;
    }
}
