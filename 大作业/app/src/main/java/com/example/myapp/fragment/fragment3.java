package com.example.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.DrawActivity;
import com.example.myapp.LoginActivity;
import com.example.myapp.MainActivity;
import com.example.myapp.R;

import org.w3c.dom.Text;

public class fragment3 extends Fragment {
    Button button;
    Button draw;
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page3,container,false);

        textView=(TextView)view.findViewById(R.id.tv_userName);
        textView.setText(((MainActivity)getActivity()).GetUsername());
        button=(Button)view.findViewById(R.id.btn_exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        button=(Button)view.findViewById(R.id.draw);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), DrawActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
