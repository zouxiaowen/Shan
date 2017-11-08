package com.example.administrator.myapplication.ceshi;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.widget.Toast;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler instance = new CrashHandler();
    private Context mContext;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return instance;
    }

    public void setCustomCrashHanler(Context context) {
        mContext = context;
        //崩溃时将catch住异常
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    //崩溃时触发
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {


        showToast(mContext, "很抱歉，程序异常即将退出！");
        //Toast.makeText(mContext,"很抱歉，程序异常即将退出！",Toast.LENGTH_LONG).show();
        try {

            thread.sleep(1000);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //线程中展示Toast
    private void showToast(final Context context, final String msg) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Looper.prepare();//消息循环
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                Looper.loop();


            }
        }).start();
    }
}