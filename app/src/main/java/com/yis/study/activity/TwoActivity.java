package com.yis.study.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.yis.study.R;

/**
 * Created by liuyi on 2021-02-28.
 */
public class TwoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.i("qqq", "第二个界面 onCreate......");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("qqq", "第二个界面 onStart......");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("qqq", "第二个界面 onRestart......");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("qqq", "第二个界面 onResume......");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("qqq", "第二个界面 onPause......");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("qqq", "第二个界面 onStop......");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("qqq", "第二个界面 onDestroy......");
    }
}
