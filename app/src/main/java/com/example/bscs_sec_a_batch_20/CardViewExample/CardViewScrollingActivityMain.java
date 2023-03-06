package com.example.bscs_sec_a_batch_20.CardViewExample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bscs_sec_a_batch_20.R;
import com.example.bscs_sec_a_batch_20.databinding.ActivityCardViewScrollingMainBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CardViewScrollingActivityMain extends AppCompatActivity {

    private ActivityCardViewScrollingMainBinding binding;


    public ArrayList<My_Model> my_Model_List;
    public MyCardViewAdapter adapter;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCardViewScrollingMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
        recyclerView = findViewById(R.id.My_Recycler_View2);
        my_Model_List=new ArrayList<>();
        adapter = new MyCardViewAdapter(this,my_Model_List);

        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        InsertData();

    }

    public void InsertData()
    {
        int[]mydrawables= new int[]

                {
                        R.drawable.icon,R.drawable.icon2,R.drawable.icon3,R.drawable.icon2,R.drawable.icon2
                };

    My_Model my_model = new My_Model("My First Card View",40,mydrawables[0]);

    my_Model_List.add(my_model);

    my_model=new My_Model("My Second Card View",45,mydrawables[1]);
    my_Model_List.add(my_model);





        my_model=new My_Model("My Second Card View",45,mydrawables[2]);
        my_Model_List.add(my_model);



        my_model=new My_Model("My Second Card View",45,mydrawables[3]);
        my_Model_List.add(my_model);



        my_model=new My_Model("My Second Card View",45,mydrawables[4]);
        my_Model_List.add(my_model);

        adapter.notifyDataSetChanged();

    }


}