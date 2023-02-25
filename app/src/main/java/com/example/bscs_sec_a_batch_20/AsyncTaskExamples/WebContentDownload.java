package com.example.bscs_sec_a_batch_20.AsyncTaskExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bscs_sec_a_batch_20.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.xml.transform.sax.SAXResult;

public class WebContentDownload extends AppCompatActivity {


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content_download);
        textView=findViewById(R.id.edtasynctask);

    }

    public void Download_Web_Content(View view) {
        DownloadWebContent obj = new DownloadWebContent();
        try {
            String receiveData =obj.execute("https://www.google.com/").get();
            textView.setText(receiveData);
            Log.d("TAG","Back in Main");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public class DownloadWebContent extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {

                Log.d("TAG","Do in Background in Po=rogress");

                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();
                String webContent="";
                while (data!=-1)
                {
                    char ch = (char) data;
                    webContent +=ch;
                    data= reader.read();

                }
                return  webContent;

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
}