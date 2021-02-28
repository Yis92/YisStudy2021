package com.yis.study.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.yis.study.R;

/**
 * 四大组件之 Activity 学习
 * Created by liuyi on 2021-02-27.
 */
public class MyActivity extends Activity {

    private Button mBtnGo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mBtnGo = findViewById(R.id.btn_go);

        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, TwoActivity.class));
            }
        });
        Log.i("qqq", "第一个界面 onCreate......");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("qqq", "第一个界面 onStart......");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("qqq", "第一个界面 onRestart......");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("qqq", "第一个界面 onResume......");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("qqq", "第一个界面 onPause......");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("qqq", "第一个界面 onStop......");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("qqq", "第一个界面 onDestroy......");
    }
}
