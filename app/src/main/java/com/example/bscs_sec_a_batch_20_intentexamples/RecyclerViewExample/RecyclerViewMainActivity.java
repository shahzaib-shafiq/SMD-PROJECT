package com.example.bscs_sec_a_batch_20_intentexamples.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;

public class RecyclerViewMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MyMobile> MyMobileList=new ArrayList<>();
    MyMobileAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);


        recyclerView=findViewById(R.id.my_recycler_view);
        adapter= new MyMobileAdapter(MyMobileList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        Insert();
    }

    public void Insert()
    {

        MyMobile obj1 = new MyMobile("S-10","Samsung","1000000");
        MyMobileList.add(obj1);
        adapter.notifyDataSetChanged();


        MyMobile obj2 = new MyMobile("S-10","Samsung","1000000");
        MyMobileList.add(obj2);
        adapter.notifyDataSetChanged();
        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
//        MyMobileList.add(obj2);
    }
}