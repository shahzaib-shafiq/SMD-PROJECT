package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bscs_sec_a_batch_20.R;

import java.util.HashMap;

public class EditContactActivity extends AppCompatActivity {
    Button delButton,updateButton;
    EditText editfirstname,editsecondname,editphonenumber,editemailaddress,edithomeaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        String id  = intent.getExtras().getString("key");
        DBQueries dbQueries = new DBQueries(getApplicationContext());
        HashMap<String,String> singleConact= dbQueries.getSingleContact(id);
        updateButton=findViewById(R.id.btnupdate);
        delButton=findViewById(R.id.btndelete);
        editfirstname=findViewById(R.id.editfirstname);
        editsecondname=findViewById(R.id.editsecondname);
        editphonenumber   =findViewById(R.id.editphonenumber);
        editemailaddress=findViewById(R.id.editemailaddress);
        edithomeaddress=findViewById(R.id.edithomeaddress);



    }

    public void UpdateData(View view) {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    public void DeleteData(View view) {

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
}