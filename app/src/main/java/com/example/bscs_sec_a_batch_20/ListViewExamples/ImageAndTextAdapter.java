package com.example.bscs_sec_a_batch_20.ListViewExamples;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bscs_sec_a_batch_20.R;

public class ImageAndTextAdapter extends ArrayAdapter<String> {

    Activity activity;
    String[] Name;
    String[] Text;
    int[] Image;


    public ImageAndTextAdapter(@NonNull  Activity activity, String[] name, String[] text, int[] image) {
        super(activity,R.layout.imageandtext,text);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        View viewHolder = inflater.inflate(R.layout.imageandtext,null);
        TextView textName= viewHolder.findViewById(R.id.txtoneimageandtext);
        TextView textText= viewHolder.findViewById(R.id.txttwoimageandtext);
        ImageView imageView = viewHolder.findViewById(R.id.imgimageandtext);



        textName.setText(Name[position]);
        textText.setText(Text[position]);
        imageView.setImageResource(Image[position]);
        return  viewHolder;
    }
}
