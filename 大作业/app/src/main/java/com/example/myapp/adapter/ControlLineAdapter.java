package com.example.myapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.bean.ControlLine;

import java.util.List;

public class ControlLineAdapter extends BaseAdapter {
    private Context context;
    private List<ControlLine> controlLineList;

    public ControlLineAdapter(Context context, List<ControlLine> controlLineList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.controlLineList = controlLineList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return controlLineList.size();
        //返回集合数据数量
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return controlLineList.get(position);//返回子项
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;//返回子项 Id
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ControlLineAdapter.ViewHolder holder = new ControlLineAdapter.ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_item_control_line, null, false);
            if (position % 2 == 0) {
                //设置奇偶项背景颜色
                convertView.setBackgroundColor(Color.argb(51, 246, 211, 101));
            } else {
                convertView.setBackgroundColor(Color.argb(51, 253, 160, 133));
            }
            /**得到各个控件的对象*/
            holder.day = (TextView) convertView.findViewById(R.id.year);
            holder.category = (TextView) convertView.findViewById(R.id.category);
            holder.batch = (TextView) convertView.findViewById(R.id.batch);
            holder.controlLine = (TextView) convertView.findViewById(R.id.controlLine);
            convertView.setTag(holder);//绑定 ViewHolder 对象
        } else {
            holder = (ControlLineAdapter.ViewHolder) convertView.getTag();
            //取出 ViewHolder 对象
        }
        holder.day.setText(controlLineList.get(position).getControlDay() + "");
        holder.category.setText(controlLineList.get(position).getCategoryName());
        holder.batch.setText(controlLineList.get(position).getBatchName());
        holder.controlLine.setText(controlLineList.get(position).getControlLine() + " ");
        return convertView;
    }

    public final class ViewHolder {
        public TextView day;
        public TextView category;
        public TextView batch;
        public TextView controlLine;
    }
}
