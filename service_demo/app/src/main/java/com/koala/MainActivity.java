package com.koala;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.DownloadBinder downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.currentProgress();
        }
    };
    private MyService.DownloadBinder downloadBinder;
    private final ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(this.getClass().getName(), "connection");
            downloadBinder = (MyService.DownloadBinder) service;
        }
    };
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);

        btn1.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        });

        btn2.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        });

        btn3.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyService.class);
            bindService(intent, connection, BIND_AUTO_CREATE);
        });

        btn4.setOnClickListener((v) -> {
//            Intent intent = new Intent(this, MyService.class);
            unbindService(connection);
        });

        btn5.setOnClickListener((v) -> {
            Intent intent = new Intent(this, ForegroundService.class);
            startForegroundService(intent);
        });

        btn6.setOnClickListener((v) -> {
            Intent intent = new Intent(this, ForegroundService.class);
            stopService(intent);
        });

        btn7.setOnClickListener(v -> {
            downloadBinder.startDownload();
        });

//        Intent intent = new Intent(this, DownloadService.class);
//        startService(intent); // 启动服务
//        bindService(intent, connection, BIND_AUTO_CREATE); // 绑定服务
//        btn7.setOnClickListener((v) -> {
//            downloadBinder.startDownload("https://images.unsplash.com/photo-1682695798522-6e208131916d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3870&q=80");
//        });

    }
}