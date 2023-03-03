package com.example.bscs_sec_a_batch_20.intentexample;

import static com.example.bscs_sec_a_batch_20.R.id.intentimgallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bscs_sec_a_batch_20.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class intentDialPadExample extends AppCompatActivity {

    ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_dial_pad_example);
    imageView = findViewById(R.id.intentimgallery);

    }

    public void OpenDialPad(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+123456789"));
        startActivity(intent);
                                        }

    public void OpenBrowser(View view) {

        Intent intent  = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        startActivity(intent);
    }

    public void OpenGallery(View view) {

Intent intent = new Intent();
intent.setType("image/*");
intent.setAction(Intent.ACTION_GET_CONTENT);
intent.addCategory(Intent.CATEGORY_OPENABLE);
startActivityForResult(intent,101);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==101&&resultCode==RESULT_OK)
            {
                try {
                    InputStream inputStream = getContentResolver().openInputStream(intent.getData());

                    if (bitmap!=null)
                    {
                        bitmap.recycle();
                    }
                    bitmap= BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}