package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityContactList extends AppCompatActivity {

    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);
        DBQueries dbQueries = new DBQueries(getApplicationContext());

    listView= findViewById(R.id.dblist);

    ArrayList<HashMap<String,String>> contactlist = dbQueries.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(this,contactlist,R.layout.newlayoutmain,

                new String[]{"_id","firstName","lastName","phoneNumber","emailAddress","homeAddress"},

                new int[]{R.id.txtid,R.id.txtfirstname,R.id.txtlastname,R.id.txtphone,R.id.txtemailAddress,R.id.txthomeAddress}
                );


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent intent = new Intent(MainActivityContactList.this,EditContactActivity.class);
            intent.putExtra("id",String.valueOf(pos+1));
            startActivity(intent);


            }
        });

    }

    public void OpenNewContactActivity(View view) {

        Intent intent = new Intent(this,NewContactActivity.class);
        startActivity(intent);

    }
}