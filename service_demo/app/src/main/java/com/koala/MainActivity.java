package com.koala;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.DownloadBinder downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.currentProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

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
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        });

        btn4.setOnClickListener((v) -> {
//            Intent intent = new Intent(this, MyService.class);
            unbindService(serviceConnection);
        });

        btn5.setOnClickListener((v) -> {
            Intent intent = new Intent(this, ForegroundService.class);
            startForegroundService(intent);
        });

        btn6.setOnClickListener((v) -> {
            Intent intent = new Intent(this, ForegroundService.class);
            stopService(intent);
        });

    }
}