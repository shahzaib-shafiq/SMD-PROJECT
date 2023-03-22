package com.example.bscs_sec_a_batch_20.FragmentExamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;

public class FragmantExampleoneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragmant_exampleone_main);
        FragmentManager FM=getSupportFragmentManager();
        FragmentTransaction FT=FM.beginTransaction();

        Configuration config = getResources().getConfiguration();

        if(config.orientation==Configuration.ORIENTATION_PORTRAIT)
        {
            PM_Fragment pm_fragment = new PM_Fragment();
            FT.replace(android.R.id.content,pm_fragment);

        }
        else {
            LM_Fragment lm_fragment = new LM_Fragment();
            FT.replace(android.R.id.content,lm_fragment);

        }
        FT.commit();


    }
}