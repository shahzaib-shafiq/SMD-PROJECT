package com.example.bscs_sec_a_batch_20.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bscs_sec_a_batch_20.R;


public class SecondActivity extends AppCompatActivity {
 TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    textView=findViewById(R.id.txtintentsecondactivity);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String v1 = intent.getStringExtra("A1");
        String v2 = intent.getStringExtra("A2");
        textView.setText(v1+"   "+v2);


    }
}