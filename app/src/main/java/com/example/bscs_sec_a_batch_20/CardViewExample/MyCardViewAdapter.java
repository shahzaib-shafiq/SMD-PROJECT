package com.example.bscs_sec_a_batch_20.CardViewExample;

import android.content.Context;
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
import java.util.List;

public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.My_CardView_Holder> {

public Context context;
public List<My_Model> modelList;

    public MyCardViewAdapter(Context context, ArrayList<My_Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public My_CardView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card,parent,false);

        return new My_CardView_Holder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull My_CardView_Holder holder, int position) {
            My_Model my_model=  modelList.get(position);
            holder.name.setText(my_model.getName());
            holder.count.setText((String.valueOf(my_model.getDownloadCount())));
        Glide.with(context).load(my_model.getThumbnail()).into(holder.thubmnail);

    }

    @Override
    public int getItemCount() {
       return modelList.size();
    }

    public class My_CardView_Holder extends RecyclerView.ViewHolder
    {

        ImageView thubmnail;
        TextView name,count;

        public My_CardView_Holder(@NonNull View v) {
            super(v);
            thubmnail=v.findViewById(R.id.imgcardview);
            name=v.findViewById(R.id.txt1cardview);
            count=v.findViewById(R.id.txt2cardview);

        }
    }
}
