package com.yis.study.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yis.study.R;

/**
 * Created by liuyi on 2021-02-26.
 */
public class MyHandlerThread extends Activity {

    private Handler handler;
    private Button btnGo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        btnGo = findViewById(R.id.btn_go);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandlerThread handlerThread = new HandlerThread("handler_thread");
                handlerThread.start();
                handler = new Handler(handlerThread.getLooper()) {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        // 该回调是在子线程中执行，可以执行耗时操作
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };

                handler.sendMessage(new Message());

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("qqq",Thread.currentThread().getName());

                        Toast.makeText(MyHandlerThread.this, "123", Toast.LENGTH_LONG).show();
                    }
                });

                Log.i("qqq","out=="+Thread.currentThread().getName());

            }
        });
    }


}
