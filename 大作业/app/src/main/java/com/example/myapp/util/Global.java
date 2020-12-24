package com.example.myapp.util;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

public class Global {
    public static String DB_PATH;   //数据库路径
    public static String DB_NAME = "bk.db";    //数据库名称

    public static GetSQLite getSQLite;
    public static SQLiteDatabase db;
    public static SharedPreferences initPreferences;
}
