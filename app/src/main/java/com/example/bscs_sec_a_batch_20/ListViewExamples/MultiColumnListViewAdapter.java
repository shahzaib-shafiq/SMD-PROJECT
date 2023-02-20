package com.example.bscs_sec_a_batch_20.ListViewExamples;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bscs_sec_a_batch_20.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewAdapter extends BaseAdapter {

    public ArrayList<HashMap<String,String>> list ;
    Activity activity;
    public static final String First_Column = "first";
    public static final String Second_Column = "second";
    public static final String Third_Column = "third";

    public MultiColumnListViewAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = activity.getLayoutInflater();
        ViewHolder viewHolder = new ViewHolder();

        if (view==null) {
            view = inflater.inflate(R.layout.multicolumnlistview, null);
            viewHolder.textView1 = view.findViewById(R.id.txt1multicolumnexample);
            viewHolder.textView2 = view.findViewById(R.id.txt2multicolumn);
            viewHolder.textView3 = view.findViewById(R.id.txt3multicolumn);
        view.setTag(viewHolder);


        }
else {
    viewHolder= (ViewHolder) view.getTag();
}

HashMap<String,String> hashMap = new HashMap<String,String>();
hashMap = list.get(i);
viewHolder.textView1.setText(hashMap.get(First_Column));
        viewHolder.textView2.setText(hashMap.get(Second_Column));
        viewHolder.textView3.setText(hashMap.get(Third_Column));

        return  view;
    }

    public class ViewHolder{
        TextView textView1,textView2,textView3;

    }
}
