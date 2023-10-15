package com.koala;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    public static final String TAG = "Koala";

    private final RemoteServer.Stub binder = new RemoteServer.Stub() {

        @Override
        public String getMessage(String msg) throws RemoteException {
            Log.i("Koala", "getMessage");
            return "helle world " + msg;
        }
    };

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind Start");
        // TODO: Return the communication channel to the service.
        return binder;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "RemoteService Start");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand Start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy Start");
        super.onDestroy();
    }
}