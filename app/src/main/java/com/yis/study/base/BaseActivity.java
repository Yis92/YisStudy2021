package com.yis.study.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * Created by liuyi on 2021-03-01.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initData();
}
