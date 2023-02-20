package com.example.bscs_sec_a_batch_20.SharedPrefrenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;

public class SharedPrefrenceExampleOne extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)


    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrence_example_one);

    sharedPreferences=getSharedPreferences("MyFile",0);
    //textView=findViewById(R.id.txtsharedprefexampleone);
    listView=findViewById(R.id.mylistviewpref);


    }

    @Override
    protected void onStart() {
        super.onStart();

            int a = sharedPreferences.getInt("A",0);
            String b = sharedPreferences.getString("B",null);
            String c = sharedPreferences.getString("C",null);
            String d = sharedPreferences.getString("D",null);


        ArrayList<String> myNameList = new ArrayList<>();
        myNameList.add(String.valueOf(a));
        myNameList.add(b);
        myNameList.add(c);
        myNameList.add(d);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myNameList);
        listView.setAdapter(myAdapter);

    }
    public void Save_My_Preference(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("A",100);
        editor.putString("B","Ali");
        editor.putString("C","Ahmed");
        editor.putString("D","Umair");
        editor.putString("E","Muhammad");
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }
    public void Show_My_Preference(View view) {
        int a = sharedPreferences.getInt("A",0);
        String b = sharedPreferences.getString("B",null);
        //textView.setText(String.valueOf(a)+"  "+b);
    }
}