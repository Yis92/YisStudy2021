package com.yis.study.handler;

import android.app.Activity;
import android.app.IntentService;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yis.study.R;

/**
 * Created by liuyi on 2021-02-25.
 */
public class HandlerActivity<T> extends Activity {


    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };



    @Override
    protected synchronized void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        new Thread(new Runnable() {
            @Override
            public void run() {

                Looper.prepare();


                Handler handler = new Handler(Looper.myLooper()) {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                    }
                };

                Looper.loop();

                handler.sendMessage(Message.obtain());

            }

        }).start();

    }
}
