package com.yis.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by liuyi on 2021-02-28.
 */
public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("qqq","service onCreate....");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("qqq","service onStartCommand ....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("qqq","service onDestroy....");
        super.onDestroy();
    }




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("qqq","service onBind....");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("qqq","service onUnbind....");
        return super.onUnbind(intent);
    }
}
