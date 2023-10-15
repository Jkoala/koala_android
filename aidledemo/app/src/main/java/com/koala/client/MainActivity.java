package com.koala.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.koala.server.RemoteServer;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private RemoteServer remoteServer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("koala", "onServiceConnected");
                remoteServer = RemoteServer.Stub.asInterface(service);
                try {
                    textView.setText(remoteServer.getMessage("Tom"));
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent intent = new Intent();
        intent.setAction("com.koala.server.action");
        intent.setPackage("com.koala.server");
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }
}