package com.example.administrator.myapplication.Activity;

import android.app.Application;

import com.example.administrator.myapplication.ceshi.CrashHandler;

/**
 * Created by Administrator on 2017/5/23.
 */

public class Application_z extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.setCustomCrashHanler(getApplicationContext());

        CrashHandler_z crashHandler = CrashHandler_z.getInstance();
        crashHandler.init(this);
    }
}
