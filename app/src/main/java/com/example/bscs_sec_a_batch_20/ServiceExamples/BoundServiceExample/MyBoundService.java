package com.example.bscs_sec_a_batch_20.ServiceExamples.BoundServiceExample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
public class MyBoundService extends Service
{


    public static final String TAG="TAG";
    private final Binder myBinder= new MyBinder();


    public MediaPlayer mediaPlayer;


    public void Play(){
        mediaPlayer.start();

    }
    public void Pause(){
        mediaPlayer.pause();

    }

    public boolean isPlay(){
        return mediaPlayer.isPlaying();

    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"OnBind() Started");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"OnUnBind() Started");
        return super.onUnbind(intent);
    }

    public class MyBinder  extends Binder
    {
        MyBoundService getServiceMethod()
        {
            return MyBoundService.this;
        }
    }
}
