package com.yis.study.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.yis.study.R;

/**
 * 四大组件之 Service 学习
 * Created by liuyi on 2021-02-27.
 */
public class MyServiceActivity extends Activity {

    /**
     * start service
     */
    private Button btnStartService;
    private Button btnStopService;
    private Button btnStartService2;

    /**
     * bind service
     */
    private Button btnBindService;
    private Button btnUnbindService;

    private BindMyService.SimpleBinder mBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStopService = findViewById(R.id.btn_stop_service);
        btnStartService2 = findViewById(R.id.btn_start_service2);

        btnBindService = findViewById(R.id.btn_bind_service);
        btnUnbindService = findViewById(R.id.btn_unbind_service);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MyServiceActivity.this, MyService.class));
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MyServiceActivity.this, MyService.class));
            }
        });

        btnStartService2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MyServiceActivity.this, BindMyService.class));
            }
        });

        btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent(MyServiceActivity.this, BindMyService.class);
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);
            }
        });

        btnUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mConnection);
            }
        });
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("qqq", "onServiceConnected...");
            mBinder = (BindMyService.SimpleBinder) service;
            mBinder.doTask();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("qqq", "onServiceDisconnected...");
        }
    };
}
