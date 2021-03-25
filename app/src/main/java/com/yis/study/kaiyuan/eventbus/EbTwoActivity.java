package com.yis.study.kaiyuan.eventbus;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by liuyi on 2021-03-24.
 */
public class EbTwoActivity extends BaseActivity {

    @BindView(R.id.btn_send)
    protected Button btnSend;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_eb_two;
    }

    @Override
    protected void initData() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("qqq","发送线程=="+Thread.currentThread().getName());
                EventBus.getDefault().post(new MessageEvent("haha"));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("qqq","发送线程22=="+Thread.currentThread().getName());
                        EventBus.getDefault().post(new MessageEvent("haha thread"));
                    }
                }).start();
                finish();
            }
        });
    }
}
