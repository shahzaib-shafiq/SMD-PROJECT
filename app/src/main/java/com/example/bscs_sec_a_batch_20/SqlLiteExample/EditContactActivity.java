package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;

import java.util.HashMap;

public class EditContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        String id  = intent.getExtras().getString("key");
        DBQueries dbQueries = new DBQueries(getApplicationContext());
        HashMap<String,String> singleConact= dbQueries.getSingleContact(id);


    }
}