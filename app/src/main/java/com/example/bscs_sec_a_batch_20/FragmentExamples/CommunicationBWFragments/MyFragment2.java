package com.example.bscs_sec_a_batch_20.FragmentExamples.CommunicationBWFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bscs_sec_a_batch_20.R;

public class MyFragment2 extends Fragment
{
    TextView textView;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragmentonelayout, container, false);
        return view;
    }

    public void OnFragmentInteraction(String Message)
    {
        textView = view.findViewById(R.id.cmfragmenttxt);
        textView.setText(Message);
    }
}
