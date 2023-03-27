package com.example.bscs_sec_a_batch_20.FragmentExamples.CommunicationBWFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bscs_sec_a_batch_20.R;

public class CMMainActivity extends AppCompatActivity implements ButtonPressListener.OnButtonPressListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmmain);
    }

    @Override
    public void onButtonPressed(String Message)
    {
        MyFragment2 obj = (MyFragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);
        obj.OnFragmentInteraction(Message);
    }
}