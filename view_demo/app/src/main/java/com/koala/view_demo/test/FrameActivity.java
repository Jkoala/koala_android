package com.koala.view_demo.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.koala.view_demo.R;

public class FrameActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        textView = findViewById(R.id.frame_t1);
        textView.setGravity(Gravity.CENTER);

        View view = getLayoutInflater().inflate(R.layout.frame_item, null);
        addContentView(view,new FrameLayout.LayoutParams(100,30));
    }
}