package com.example.bscs_sec_a_batch_20.ServiceExamples.BoundServiceExample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.bscs_sec_a_batch_20.R;
import com.example.bscs_sec_a_batch_20.ServiceExamples.BoundServiceExample.MyBoundService;

public class BoundServiceExample extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    public MyBoundService myBoundService;
    private boolean myBoundServiceFlag = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mediaPlayer=MediaPlayer.create(this,R.raw.small);

    }

   private ServiceConnection myserviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService=myBinder.getServiceMethod();
            myBoundServiceFlag=true;
            Log.d("Tag","Connection Created");

        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_example);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(this,MyBoundService.class);
        bindService(intent,myserviceConnection,BIND_AUTO_CREATE);


    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myBoundServiceFlag==true)
        {
            unbindService(myserviceConnection);

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public void PlayPause(View view) {
        if(myBoundServiceFlag==true)
        {
            if(!myBoundService.isPlay())
            {
                myBoundService.Play();
            }
            else {
                myBoundService.Pause();
            }
        }

    }
}