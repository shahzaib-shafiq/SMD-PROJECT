package com.example.bscs_sec_a_batch_20.AsyncTaskExamples;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bscs_sec_a_batch_20.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class AsyncTaskExampleOne extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example_one);
    imageView=findViewById(R.id.imgasynctask);
    }

    public void Download_Image_AsyncTask(View view) {

        DownloadImage obj = new DownloadImage();
        Bitmap bitmap;
        try {
            bitmap = obj.execute("https://cdn.thinglink.me/api/image/854796788643659778/1240/10/scaletowidt").get();
            imageView.setImageBitmap(bitmap);
            Log.d("TAG","Back in Main");


        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

        public class DownloadImage extends AsyncTask<String,Void, Bitmap> {

            protected Bitmap doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    try {
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.connect();
                        InputStream inputStream = connection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        Log.d("TAG", "DO in Background  Progress");
                        return bitmap;

                    }

                    catch (IOException e) {

                        throw new RuntimeException(e);
                    }
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);


                }
            }

        }
}