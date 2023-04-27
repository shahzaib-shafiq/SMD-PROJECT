package com.example.bscs_sec_a_batch_20.BroadCastExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;

public class AirplaneModeChangeMainActivity extends AppCompatActivity {

    AirplaneModeChange airplaneModeChange= new AirplaneModeChange();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airplane_mode_change_main);

    }



    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChange,intentFilter);



    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChange);

    }
}