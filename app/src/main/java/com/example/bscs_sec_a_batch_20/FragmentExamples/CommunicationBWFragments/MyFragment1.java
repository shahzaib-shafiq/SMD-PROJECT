package com.example.bscs_sec_a_batch_20.FragmentExamples.CommunicationBWFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bscs_sec_a_batch_20.R;

public class MyFragment1 extends Fragment
{
    ButtonPressListener.OnButtonPressListener buttonPressListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener = (ButtonPressListener.OnButtonPressListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragmentonelayout, container, false);
        myFunction(viewGroup);

        return viewGroup;
    }

    private void myFunction(ViewGroup viewGroup)
    {
        TextView textView = viewGroup.findViewById(R.id.cmfragmenttxt);
        textView.setOnClickListener(view -> buttonPressListener.onButtonPressed("Message from Fragment One ..."));
    }
}
