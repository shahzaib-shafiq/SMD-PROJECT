package com.example.bscs_sec_a_batch_20.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewStudentExampleMainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<NewStudent> messageList;
    FirebaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student_example_main);
        recyclerView = findViewById(R.id.firebaserecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        database = FirebaseDatabase.getInstance("https://bscs-sec-a-batch-20-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabse");
        messageList = new ArrayList<>();
        readDataFromFirebase();
    }

    public void readDataFromFirebase()
    {
        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    NewStudent student = new NewStudent();
                    student.setName(snapshot.child("Name").getValue().toString());
                    student.setUrl(snapshot.child("Picture").getValue().toString());
                    messageList.add(student);
                }

                adapter = new FirebaseAdapter(messageList, getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }
}