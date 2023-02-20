package com.example.bscs_sec_a_batch_20.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bscs_sec_a_batch_20.R;

public class ListViewExampleOne extends AppCompatActivity {
    String[] StudentList = {"Ali", "Umair", "Ahmed", "Jabbar", "Toqeer", "Mustafa"};
    Integer[] MobileList={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

    ListView listView;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example_one);
        listView = findViewById(R.id.mylistviewexampleone);
        imageView=findViewById(R.id.lstex1imageview);
        // listView.setOnItemClickListener();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        ArrayAdapter adapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StudentList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ListViewExampleOne.this, "Clicked",Toast.LENGTH_SHORT).show();

                if (i<=4 && i<=4)
        {
            imageView.setImageResource(MobileList[i]);
        }
            }

        });
    }
}


