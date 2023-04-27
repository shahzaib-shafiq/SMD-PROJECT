package com.example.bscs_sec_a_batch_20.SqlLiteExample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bscs_sec_a_batch_20.R;

import java.util.HashMap;

public class EditContactActivity extends AppCompatActivity {
    Button delButton,updateButton;
    EditText editfirstname,editsecondname,editphonenumber,editemailaddress,edithomeaddress;
    DBQueries dbQueries;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        id  = intent.getExtras().getString("id");
        dbQueries = new DBQueries(getApplicationContext());
        HashMap<String,String> singleConact= dbQueries.getSingleContact(id);
        updateButton=findViewById(R.id.btnupdate);
        delButton=findViewById(R.id.btndelete);
        editfirstname=findViewById(R.id.editfirstname);
        editsecondname=findViewById(R.id.editsecondname);
        editphonenumber   =findViewById(R.id.editphonenumber);
        editemailaddress=findViewById(R.id.editemailaddress);
        edithomeaddress=findViewById(R. id.edithomeaddress);

    }

    public void UpdateData(View view) {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String,String> contact = new HashMap<String,String>();
                contact.put("firstName",editfirstname.getText().toString());
                contact.put("lastName",editsecondname.getText().toString());
                contact.put("phoneNumber",editphonenumber.getText().toString());
                contact.put("emailAddress",editemailaddress.getText().toString());
                contact.put("homeAddress",edithomeaddress.getText().toString());
                dbQueries.UpdateContact(contact,id);



            }
        });

    }

    public void DeleteData(View view) {

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)

            {
            dbQueries.DeleteContact(id);
            }
        });

    }
}