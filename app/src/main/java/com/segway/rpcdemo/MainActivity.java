package com.segway.rpcdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String ACTION = "com.segway.rpcdemo.MyService";
    private IPlay play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.setPackage("com.segway.rpcdemo");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            play = IPlay.Stub.asInterface(iBinder);
            if (play != null) {
                try {
                    play.setName("demo");
                    play.toString();
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
