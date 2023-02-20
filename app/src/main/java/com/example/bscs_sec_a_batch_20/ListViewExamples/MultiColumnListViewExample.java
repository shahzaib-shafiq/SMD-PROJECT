package com.example.bscs_sec_a_batch_20.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewExample extends AppCompatActivity {

    public ArrayList<HashMap<String,String>> list;
    public static final String First_Column = "first";
    public static final String Second_Column = "second";
    public static final String Third_Column = "third";



    ListView listView ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_example);
        listView = findViewById(R.id.lstmulticolumnexample);
        list = new ArrayList<HashMap<String,String>>();

        loadData();
        MultiColumnListViewAdapter adapter = new MultiColumnListViewAdapter(list,this);
        listView.setAdapter(adapter);

    }

    public  void loadData()
    {
        HashMap<String,String>hashMap1 = new HashMap<String,String>();
        hashMap1.put(First_Column,"Ali");
        hashMap1.put(Second_Column,"Ahmed");
        hashMap1.put(Third_Column,"Ajaz");
        list.add(hashMap1);



        HashMap<String,String>hashMap2 = new HashMap<String,String>();
        hashMap2.put(First_Column,"Aslam");
        hashMap2.put(Second_Column,"Aman");
        hashMap2.put(Third_Column,"zafar");
        list.add(hashMap2);


        HashMap<String,String>hashMap3 = new HashMap<String,String>();
        hashMap3.put(First_Column,"Shahzaib");
        hashMap3.put(Second_Column,"Shafiq");
        hashMap3.put(Third_Column,"Shahrukh");
        list.add(hashMap3);






    }

}


