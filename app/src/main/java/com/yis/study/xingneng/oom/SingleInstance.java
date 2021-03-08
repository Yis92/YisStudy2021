package com.yis.study.xingneng.oom;

import android.content.Context;
import android.util.Log;

/**
 * Created by liuyi on 2021-03-08.
 */
public class SingleInstance {

    private Context mContext;
    private static SingleInstance instance;

    private SingleInstance(Context context) {
        this.mContext = context;
    }

    public static SingleInstance getInstance(Context context) {
        if (instance == null) {
            instance = new SingleInstance(context);
        }
        return instance;
    }

    public void say() {
        Log.i("tag", "this is single instance");
        Log.i("tag", "：code：" + instance.hashCode());
    }
}
