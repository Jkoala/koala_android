package com.koala.view_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.koala.view_demo.test.FrameActivity;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons = new Button[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = findViewById(R.id.button1);
        buttons[0].setOnClickListener(v->{
            Intent intent = new Intent(this, FrameActivity.class);
            startActivity(intent);
        });
    }



}