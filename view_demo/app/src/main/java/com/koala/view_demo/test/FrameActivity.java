package com.koala.view_demo.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.koala.view_demo.R;

public class FrameActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        ImageView imageView = findViewById(R.id.img);


        View view = getLayoutInflater().inflate(R.layout.frame_item, null);
        FrameLayout frameLayout = (FrameLayout) view;
        FrameLayout father = (FrameLayout) frameLayout.getChildAt(0);
        EditText child = (EditText) father.getChildAt(0);
        child.setGravity(Gravity.CENTER);


        Bitmap bitmap = view.getDrawingCache();
    }
}