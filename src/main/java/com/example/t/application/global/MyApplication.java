package com.example.t.application.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Vector;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 09:59
 * 作 者：T
 * 微信：704003376
 */
public class MyApplication extends Application {
    public static Context mCtontext;
    public  static Vector<Activity> objectVector;
    public SharedPreferences msp;

    @Override
    public void onCreate() {
        objectVector = new Vector<Activity>();
        msp = getSharedPreferences("config", MODE_PRIVATE);
        super.onCreate();
    }
}
