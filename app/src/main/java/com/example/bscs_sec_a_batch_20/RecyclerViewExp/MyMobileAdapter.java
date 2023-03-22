package com.example.bscs_sec_a_batch_20.RecyclerViewExp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;

public class MyMobileAdapter extends RecyclerView.Adapter<MyMobileAdapter.ViewHolder> {

private ArrayList<MyMobile> MyMobileList;

    public MyMobileAdapter(ArrayList<MyMobile> myMobileList) {
        MyMobileList = myMobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_row,parent,false);

        //return ViewHolder(view);
        ViewHolder obj = new ViewHolder(view);
        return obj;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        MyMobile myMobile =  MyMobileList.get(position);
        holder.M_Name.setText(myMobile.getName());
        holder.M_Company.setText(myMobile.getCompany());
        holder.M_Price.setText(myMobile.getPrice());


    }

    @Override
    public int getItemCount() {
        return MyMobileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView M_Name,M_Company,M_Price;
        public ViewHolder(@NonNull View v) {
            super(v);
             M_Name=v.findViewById(R.id.txtMobileName);
             M_Company=v.findViewById(R.id.txtMobileCompany);
             M_Price=v.findViewById(R.id.txtMobilePrice);
        }
    }

}
