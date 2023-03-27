package com.example.bscs_sec_a_batch_20.FragmentExamples.StaticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;

public class StaticFragmentMainActivity extends AppCompatActivity implements ContactsFragment.ListSelectionListner {



    public static String[] contactsArray;
    public static String[] contactDetailArray;

    ContactDetailsFragment detailsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment_main);
        contactsArray= getResources().getStringArray(R.array.contacts_array);
        contactDetailArray=getResources().getStringArray(R.array.details_array);
        detailsFragment= (ContactDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsfragment);

    }

    @Override
    public void onSelection(int position) {


        if(detailsFragment.getShownIndex()!=position)
        {
            detailsFragment.ContactIndex(position);
        }
    }


}