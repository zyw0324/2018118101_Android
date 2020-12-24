package com.example.myapp.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapp.R;
import com.example.myapp.adapter.SpotAdapter;
import com.example.myapp.bean.Spot;

import java.util.ArrayList;
import java.util.List;

public class fragment1 extends Fragment {
    private List<Spot> spotList = new ArrayList<>();
    ListView listview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.page1,container,false);

        initSpots();
        final SpotAdapter adapter = new SpotAdapter(getActivity(), R.layout.spot_item, spotList);
        listview = (ListView) view.findViewById(R.id.list_view);

        listview.setAdapter(adapter);

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("一旦删除，无法恢复！");
                builder.setTitle("删除提示");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        spotList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                return false;
            }
        });

        return view;

    }

    private void initSpots() {
        Spot hzxh = new Spot("早餐",
                "-4.5",
                R.drawable.icon);
        spotList.add(hzxh);
        Spot qdh = new Spot("奶茶",
                "-16.75",
                R.drawable.icon);
        spotList.add(qdh);
        Spot xxsd = new Spot("看电影",
                "-38",
                R.drawable.icon);
        spotList.add(xxsd);
        Spot fhs = new Spot("晚餐",
                "-12",
                R.drawable.icon);
        spotList.add(fhs);
        Spot lys = new Spot("地铁",
                "-3",
                R.drawable.icon);
        spotList.add(lys);
        Spot dcy = new Spot("红包",
                "+1000",
                R.drawable.icon);
        spotList.add(dcy);
        Spot tms = new Spot("护肤彩妆",
                "-80",
                R.drawable.icon);
        spotList.add(tms);
        Spot sgg = new Spot("零食",
                "-22",
                R.drawable.icon);
        spotList.add(sgg);
        Spot lft = new Spot("零花钱",
                "+1000",
                R.drawable.icon);
        spotList.add(lft);
        Spot jx = new Spot("口罩",
                "-240",
                R.drawable.icon);
        spotList.add(jx);
        Spot aaa = new Spot("衣服",
                "-140",
                R.drawable.icon);
        spotList.add(aaa);
        Spot bbb = new Spot("盲盒",
                "-108",
                R.drawable.icon);
        spotList.add(bbb);
        Spot ccc = new Spot("奶茶",
                "-15",
                R.drawable.icon);
        spotList.add(ccc);
    }
}