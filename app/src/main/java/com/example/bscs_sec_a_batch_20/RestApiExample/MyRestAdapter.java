package com.example.bscs_sec_a_batch_20.RestApiExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bscs_sec_a_batch_20.R;
import com.example.bscs_sec_a_batch_20.R;

import java.util.List;

public class MyRestAdapter extends RecyclerView.Adapter<MyRestAdapter.ViewHolder>
{

    public List<MyPostModel> list;
    public Context context;

    public MyRestAdapter(List<MyPostModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.myrestlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(list.get(position).getTitle());
        holder.Content.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Name, Content;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            Name = itemView.findViewById(R.id.txtrestname);
            Content = itemView.findViewById(R.id.txtrestcontnet);
        }
    }
}