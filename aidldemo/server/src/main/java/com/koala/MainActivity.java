package com.koala;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, RemoteService.class));
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, RemoteService.class));
        super.onDestroy();
    }
}