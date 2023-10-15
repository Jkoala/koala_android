package com.koala.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    private final RemoteServer.Stub binder = new RemoteServer.Stub() {
        @Override
        public String getMessage(String name) throws RemoteException {
            Log.i("koala", "获取信息");
            return "hello world " + name;
        }
    };

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}