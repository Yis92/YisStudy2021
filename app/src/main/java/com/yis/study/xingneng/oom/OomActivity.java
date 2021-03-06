package com.yis.study.xingneng.oom;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

import butterknife.BindView;

/**
 * 内存优化
 * Created by liuyi on 2021-03-05.
 */
public class OomActivity extends BaseActivity {

    @BindView(R.id.btn_mat_use)
    Button btnMatUse;

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_oom;
    }

    @Override
    protected void initData() {

//        SingleInstance.getInstance(this).say();

        btnMatUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OomActivity.this, MatUseActivity.class));
            }
        });

//        getMemorySize();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        handler.sendMessageDelayed(new Message(), 20000);


    }

    public void getMemorySize() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        //以m为单位
        int size = activityManager.getMemoryClass();
        Log.i("qqq", "内存大小为：" + size);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }


}
