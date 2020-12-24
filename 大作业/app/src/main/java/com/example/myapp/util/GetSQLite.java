package com.example.myapp.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;


import com.example.myapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GetSQLite {
    public GetSQLite(Context context) {
        Global.initPreferences = context.getSharedPreferences("dbInfo",
                Context.MODE_PRIVATE);
        boolean isInitDB = Global.initPreferences.getBoolean("initDB", false);
        if (!isInitDB) {
            initDB(context);
            Global.initPreferences.edit().putString("dbPath", Global.DB_PATH).commit();
            Global.initPreferences.edit().putBoolean("initDB", true).commit();//数据保存并提交
        } else {
            Global.DB_PATH = Global.initPreferences.getString("dbPath", "");
        }
        System.out.println("本地数据库路径：" + Global.DB_PATH);
    }

    public void initDB(Context context) {
        File externalDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        //再改路径下创建一个db文件夹
        String dbPath = externalDir.getAbsolutePath() + File.separator + "db";
        File dir = new File(dbPath);//获取db文件夹内的数据库文件夹路径
        //如果文件夹不存在
        if (!dir.exists()) {
            dir.mkdir();//新建文件夹
        }
        File file = new File(dir.getPath(), Global.DB_NAME);//get数据库文件夹下的文件
        if (!file.exists()) {//若没有数据库文件
            try {
                file.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
            copyFile(context,R.raw.bk, file); //复制资源到存储卡中
        }
        Global.DB_PATH = file.getAbsolutePath();
    }

    public void copyFile(Context context, int resId, File file) {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.bk);
            FileOutputStream fos = new FileOutputStream(file);//打开对应文件的输出流
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while ((hasRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, hasRead);
            }
            fos.close();
            is.close();//关闭资源
        } catch (Exception e) {
            System.out.println("复制文件时出错啦！");
        }
    }

    public SQLiteDatabase getDataBase(Context context) {
        return Global.db = context.openOrCreateDatabase(Global.DB_PATH,
                Context.MODE_PRIVATE, null);
    }

    public List<String> getField(Context context, String sql) { //获取数据库表中某一字段的值的集合
        List<String> fields = new ArrayList<String>();
        SQLiteDatabase db = getDataBase(context);
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            if(cursor.getString(0)!=null)
                fields.add(cursor.getString(0));
        }
        db.close();
        System.out.println(fields);
        return fields;
    }
}
