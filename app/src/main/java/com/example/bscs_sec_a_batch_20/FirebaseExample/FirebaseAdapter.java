package com.example.bscs_sec_a_batch_20.FirebaseExample;


import android.content.Context;
import android.support.v4.os.IResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.ViewHolder>
{
    ArrayList<NewStudent> studentArrayList;
    Context context;

    public FirebaseAdapter(ArrayList<NewStudent> studentArrayList, Context context)
    {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.textView.setText(studentArrayList.get(position).getName());
        Glide.with(context).load(studentArrayList.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return studentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.firebaseimageview);
            textView = view.findViewById(R.id.firebasetextview);
        }
    }
}
