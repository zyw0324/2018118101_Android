package com.example.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myapp.R;
import com.example.myapp.bean.Spot;

import java.util.List;

public class SpotAdapter extends ArrayAdapter<Spot> {
    private int resourceId;
    public SpotAdapter(Context context, int textViewResourceId, List<Spot> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Spot spot=getItem(position);   //获取当前项的实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView spotImage=(ImageView)view.findViewById(R.id.spot_image);
        TextView spotName=(TextView) view.findViewById(R.id.spot_name);
        TextView spotDescribe=(TextView)view.findViewById(R.id.spot_describe);
        spotImage.setImageResource(spot.getImageId());
        spotName.setText(spot.getName());
        spotDescribe.setText(spot.getDescribe());
        return view;
    }
}