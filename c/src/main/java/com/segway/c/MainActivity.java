package com.segway.c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.segway.s.IMaker;

public class MainActivity extends AppCompatActivity {
    private IMaker maker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAKERSERVICE");
        intent.setPackage("com.segway.s");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            maker = IMaker.Stub.asInterface(iBinder);
            if (maker != null) {
                try {
                    maker.setName("demo");
                    maker.toString();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }else {
                Log.d("Play","play==null");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
