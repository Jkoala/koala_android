package com.koala;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder downloadBinder = new DownloadBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }

    @Override
    public void onCreate() {
        Log.i(this.getClass().getName(),"onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(this.getClass().getName(),"onDestroy");
        super.onDestroy();
    }

    class DownloadBinder extends Binder {
        public void startDownload(){
            Log.i(this.getClass().getName(),"开始下载");
        }

        public void currentProgress(){
            Log.i(this.getClass().getName(),"当前进度");
        }
    }

}