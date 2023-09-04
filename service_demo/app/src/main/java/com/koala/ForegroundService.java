package com.koala;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service {
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "DataSyncChannel";

    public ForegroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(this.getClass().getName(), "onCreate");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.tag)
                .setContentTitle("DataSync")
                .setContentText("Synchronizing data...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // 创建通知渠道
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "DataSync Channel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);
        startForeground(NOTIFICATION_ID, builder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 执行数据同步任务
        // ...
        Log.i(this.getClass().getName(), "onStartCommand");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}