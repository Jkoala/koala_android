package com.koala;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;
    private RemoteServer remoteServer = null;
    private String msg;
    private TextView textView;
    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("Koala", "service connected");
            remoteServer = RemoteServer.Stub.asInterface(service);

            if (remoteServer != null) {
                try {
                    msg = remoteServer.getMessage("Tom");
                    textView.setText(msg);
                    Log.i("Koala", msg);
                } catch (RemoteException e) {
                    Log.i("Koala", "RemoteException");
                    e.printStackTrace();
                }
            } else {
                Log.i("Koala", "remoteServer == null");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("Koala", "service disconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.id1);
        textView = findViewById(R.id.text1);
//        btn2 = findViewById(R.id.id2);

        btn1.setOnClickListener(v -> {
            attemptToBindService();
        });
    }

    /**
     * 尝试与服务端建立连接
     */
    private void attemptToBindService() {
        Log.i("koala", "attemptToBindService");
        Intent intent = new Intent();
        intent.setAction("com.koala.server");
        intent.setPackage("com.koala");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }
}