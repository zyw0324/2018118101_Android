package com.example.myapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.bean.ControlLine;
import com.example.myapp.util.GetSQLite;
import com.example.myapp.util.GetService;
import com.example.myapp.adapter.ControlLineAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragment2 extends Fragment {
    private Spinner daySpinner, provinceSpinner, categorySpinner, batchSpinner;// 下拉列表控件
    //private String[] days = new String[]{"6.1", "6.2", "6.3", "6.4", "6.5"};
    private List<String> provinces = new ArrayList<String>();
    //private String[] batchs = new String[]{"食物","购物","出行","教育","娱乐","其他"};
    //private String[] categories = new String[]{"大于20","大于50","大于100","大于200"};

    private List<String> days = new ArrayList<String>();
    private List<String> batchs = new ArrayList<String>();
    private List<String> categories = new ArrayList<String>();

    private int sourceAreaId=0, dayId=0, categoryId=0, batchId=0;
    private TextView controlLineTitle;//提示标题
    private List<ControlLine> controlLineList;
    private ListView controlLineListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page2,container,false);

        daySpinner=(Spinner)view.findViewById(R.id.daySpinner);
        provinceSpinner = (Spinner) view.findViewById(R.id.areaSpinner);// 省份的下拉列表
        categorySpinner = (Spinner) view.findViewById(R.id.categorySpinner);
        batchSpinner = (Spinner) view.findViewById(R.id.batchSpinner);
        controlLineTitle = (TextView) view.findViewById(R.id.controlLineTitle);
        controlLineListView = (ListView) view.findViewById(R.id.controlLineList);

        //GetSQLite getSQLite = new GetSQLite();
        //provinces = getSQLite.setProvince();
        GetSQLite getSQLite = new GetSQLite(getActivity());  //实例化从SQLite查询数据类对象
        provinces = getSQLite.getField(getActivity(), "select ine from cash");
        days = getSQLite.getField(getActivity(), "select day from cash");
        batchs = getSQLite.getField(getActivity(), "select category from cash");
        categories = getSQLite.getField(getActivity(), "select amout from cash");

        ArrayAdapter<String> provincesAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_year, provinces);
        provinceSpinner.setAdapter(provincesAdapter);
        provinceSpinner.setSelection(sourceAreaId);//设置默认省份显示项

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_year, days);
        daySpinner.setAdapter(dayAdapter);
        daySpinner.setSelection(dayId);


        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_category, categories);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setSelection(categoryId);//设置默认科类显示项

        ArrayAdapter<String> batchAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_batch, batchs);
        batchSpinner.setAdapter(batchAdapter);
        batchSpinner.setSelection(batchId);//设置默认批次显示项

        MyItemSelectedListener itemSelectedListener = new MyItemSelectedListener();
        daySpinner.setOnItemSelectedListener(itemSelectedListener);
        provinceSpinner.setOnItemSelectedListener(itemSelectedListener);
        categorySpinner.setOnItemSelectedListener(itemSelectedListener);
        batchSpinner.setOnItemSelectedListener(itemSelectedListener);

        GetService getService=new GetService();
        controlLineList=getService.setControlLineList();
        ControlLineAdapter controlLineAdapter=new ControlLineAdapter(this.getActivity(),controlLineList);
        controlLineListView.setAdapter(controlLineAdapter);

        controlLineTitle.setText(((MainActivity)getActivity()).GetUsername() +"的账单");
        return view;
    }

    private class MyItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()) {
                case R.id.areaSpinner:// 如果是选择省份列表
                    sourceAreaId = position;
                    break;
                case R.id.daySpinner:// 如果是选择年份列表
                    dayId = position;
                    break;
                case R.id.categorySpinner:// 如果是选择科类列表
                    categoryId = position;
                    break;
                case R.id.batchSpinner:// 如果是选择批次列表
                    batchId = position;
                    break;
                default:
                    break;
            }
            /*设置标题显示*/
            //controlLineTitle.setText(days[dayId] + provinces.get(sourceAreaId));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
