package com.example.bscs_sec_a_batch_20.StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bscs_sec_a_batch_20.R;

public class ContactDetailsFragment extends Fragment {

    TextView textView;
    int currentIndex=-1;
    int arrayLength;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactdetails,container,false);
    }

    public int getShownIndex()
    {
        return currentIndex;
    }
    public void ContactIndex(int position)
    {
        if(position<0|| position>=arrayLength)
        {
            return;
        }

        currentIndex=position;
        textView.setText(StaticFragmentMainActivity.contactDetailArray[position]);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView= getActivity().findViewById(R.id.txtdetails);
        arrayLength= StaticFragmentMainActivity.contactDetailArray.length;
    }

}
