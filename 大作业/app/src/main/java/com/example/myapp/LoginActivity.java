package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

        private EditText username;
        private EditText password;
        private Button log;
        private SharedPreferences sp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = this.getSharedPreferences("userInfo", MODE_PRIVATE);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        log = (Button) findViewById(R.id.login);

        username.setText(sp.getString("username",""));
        password.setText(sp.getString("password",""));

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername=username.getText().toString();
                String strPassword=password.getText().toString();

                if(strUsername.equals("laraine")&&strPassword.equals("123")) {
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("username", strUsername);
                    editor.putString("password",strPassword);
                    editor.commit();
                    Intent intent=new Intent();
                    intent.putExtra("username", strUsername);
                    intent.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
