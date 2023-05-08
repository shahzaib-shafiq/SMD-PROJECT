package com.example.bscs_sec_a_batch_20.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bscs_sec_a_batch_20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseMainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);


        database=FirebaseDatabase.getInstance("https://bscs-sec-a-batch-20-default-rtdb.firebaseio.com/");

        reference=database.getReference("MyDatabase");
        reference.removeValue();
        textView=findViewById(R.id.txtfirebase);
    }
    public void SendDataToFireBase(View view) {
        /*
        reference.child("Student").child("Name").setValue("Shahzaib");
        reference.child("Student").child("Age").setValue("20");

        Log.d("TAG","sent");*/

//
//        String id=reference.push().getKey();
//        String Name="Shahzaib";
//        String City="Islamabad";
//
//        Fast_Student obj=new Fast_Student(id,Name,City);
//        reference.child(id).setValue(obj);


       reference.setValue("my First Message");


    }

    public void ReadFromFirebase(View view) {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value=snapshot.getValue().toString();
                textView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}