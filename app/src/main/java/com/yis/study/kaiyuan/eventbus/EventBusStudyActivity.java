package com.yis.study.kaiyuan.eventbus;

import android.content.Intent;
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
public class EventBusStudyActivity extends BaseActivity {

    @BindView(R.id.btn_go)
    Button btnGo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_eventbus_study;
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventBusStudyActivity.this, EbTwoActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND, priority = 1)
    public void onMessageEvent(MessageEvent event) {
        Log.i("qqq", Thread.currentThread().getName()+"=="+event.getMessage());
        btnGo.setText(event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent2(MessageEvent event) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
