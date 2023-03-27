package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bscs_sec_a_batch_20.R;

public class MainActivityContactList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);
        DBQueries dbQueries = new DBQueries(getApplicationContext());
    }

    public void OpenNewContactActivity(View view) {

        Intent intent = new Intent(this,NewContactActivity.class);
        startActivity(intent);

    }
}