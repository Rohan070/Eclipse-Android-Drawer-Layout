package com.example.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<Adapterclass>{

    Context context;
    int layoutResourceId;   
    Adapterclass data[] = null;
   
    public Adapter(Context context, int layoutResourceId, Adapterclass[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AdapterclassHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new AdapterclassHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
           
            row.setTag(holder);
        }
        else
        {
            holder = (AdapterclassHolder)row.getTag();
        }
       
        Adapterclass Adapterclass = data[position];
        holder.txtTitle.setText(Adapterclass.title);
        holder.imgIcon.setImageResource(Adapterclass.icon);
       
        return row;
    }
   
    static class AdapterclassHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}