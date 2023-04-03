package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bscs_sec_a_batch_20.R;

import java.util.HashMap;

public class NewContactActivity extends AppCompatActivity {
    DBQueries dbQueries;
    EditText firstName, lastName, phoneNumber, emailAddress, homeAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        dbQueries=new DBQueries(getApplicationContext());
        firstName = (EditText) findViewById(R.id.edtfirstname);
        lastName = (EditText) findViewById(R.id.edtsecondname);
        phoneNumber = (EditText) findViewById(R.id.edtphonenumber);
        emailAddress = (EditText) findViewById(R.id.edtemail);
        homeAddress = (EditText) findViewById(R.id.edthomeaddress);

    }
        public void SaveIntoDB(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("firstName",firstName.getText().toString());
        contact.put("lastName",lastName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());

        dbQueries.InsertSingleContact(contact);
        Intent intent = new Intent(this,MainActivityContactList.class);
        startActivity(intent);


    }
}