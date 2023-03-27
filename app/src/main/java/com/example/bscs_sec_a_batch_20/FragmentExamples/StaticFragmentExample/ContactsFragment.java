package com.example.bscs_sec_a_batch_20.FragmentExamples.StaticFragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.bscs_sec_a_batch_20.R;

public class ContactsFragment extends ListFragment  {


    public ListSelectionListner mlistner=null;
    public interface ListSelectionListner{

        public void onSelection(int position);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mlistner= (ListSelectionListner) getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.contacttextview,StaticFragmentMainActivity.contactsArray));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        getListView().setItemChecked(position,true);
        mlistner.onSelection(position);

    }
}
