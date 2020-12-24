package com.example.myapp;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapp.bean.Constant;
import com.example.myapp.view.ChartView;

public class DrawActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Constant.point = new Point();
        getWindowManager().getDefaultDisplay().getSize(Constant.point);//获取屏幕分辨率

        ChartView myView=new ChartView(this);
        setContentView(myView);
        myView.SetInfo(new String[] { "6-1", "6-2", "6-3", "6-4", "6-5",
                        "6-6", "6-7" }, // X轴刻度
                new String[] { "", "50", "100", "150", "200", "250" }, // Y轴刻度
                new String[] { "30", "65", "100", "80", "175", "222", "123" }, // 数据
                "每日支出折线图");


    }

    // 顶部返回键
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
