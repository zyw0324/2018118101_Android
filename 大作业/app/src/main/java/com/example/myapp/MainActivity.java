package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.myapp.fragment.fragment1;
import com.example.myapp.fragment.fragment2;
import com.example.myapp.fragment.fragment3;

public class MainActivity extends FragmentActivity {


    private TabHost mTabHost;
    private String username;
    //选项卡标记
    private String[] tags=new String[]{"page1","page2","page3"};
    private String[] titles=new String[]{"记账","查询","我的"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        mTabHost=(TabHost) findViewById(R.id.mTabHost);
        mTabHost.setup();
        for(int i=0;i<titles.length;i++){
            TabHost.TabSpec tabSpec=mTabHost.newTabSpec(tags[i]);
            View view=getLayoutInflater().inflate(R.layout.tab, null);
            TextView tv1=(TextView) view.findViewById(R.id.title);
            tv1.setText(titles[i]);
            tabSpec.setIndicator(view);
            tabSpec.setContent(R.id.content);
            mTabHost.addTab(tabSpec);
        }
        mTabHost.setOnTabChangedListener(new MyTabChangedListener());
        mTabHost.setCurrentTab(1);
    }
    public String GetUsername(){
        return username;
    }
    private class MyTabChangedListener implements TabHost.OnTabChangeListener {
        public void onTabChanged(String tabId) {
            if(tabId.equals("page1")){
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new fragment1()).commit();
            }else if(tabId.equals("page2")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new fragment2()).commit();
            }else if(tabId.equals("page3")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new fragment3()).commit();
            }
        }
    }
}
