package com.example.bscs_sec_a_batch_20.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bscs_sec_a_batch_20.R;

public class ImageAndTextExample extends AppCompatActivity {


    String Name[]={"Ali","Ahmed","Laiba","Maryam","Nawaz"};
    String Text[]= {"Hello Ali","Ok Ahmed","Noted","Vote ko izzat do","Muje q nikala"};
    int Image[]= {R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_and_test_example);
listView=findViewById(R.id.lstimageimageandtext);

ImageAndTextAdapter adapter = new ImageAndTextAdapter(this,Name,Text,Image);

listView.setAdapter(adapter);

    }
}



