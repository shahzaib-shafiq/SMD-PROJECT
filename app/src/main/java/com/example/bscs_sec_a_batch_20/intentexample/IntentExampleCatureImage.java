package com.example.bscs_sec_a_batch_20.intentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.bscs_sec_a_batch_20.R;

public class IntentExampleCatureImage extends AppCompatActivity {


    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example_cature_image);
        imageView = findViewById(R.id.imgintentcaptureimage);

    }
    public  void Send(View view)
    {
        Intent intent  = new Intent(this,SecondActivity.class);
        intent.putExtra("A1","FAST");
        intent.putExtra("A2","NATIONAL");
        startActivity(intent);
    }
    public void OpenCamera(View view) {
        Intent intent =
                new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,103);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==103 && resultCode==RESULT_OK)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);

        }
    }
}