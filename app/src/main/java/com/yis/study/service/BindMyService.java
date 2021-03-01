package com.yis.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by liuyi on 2021-02-28.
 */
public class BindMyService extends Service {

    private SimpleBinder mBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        mBinder = new SimpleBinder();
        Log.i("qqq", "service onCreate....");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("qqq", "service onStartCommand ....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("qqq", "service onBind....");
        if (mBinder != null) {
            return mBinder;
        }
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("qqq", "service onUnbind....");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("qqq", "service onDestroy....");
        super.onDestroy();
    }


    class SimpleBinder extends Binder {

        public void doTask() {
            Log.d("qqq", "doTask");
        }
    }
}
