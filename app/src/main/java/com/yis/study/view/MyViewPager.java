package com.yis.study.view;

import android.content.Context;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by liuyi on 2021-03-03.
 */
public class MyViewPager extends ViewPager {
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // ViewPager 嵌套一个 ListView
        // false 上下可以滑动
        // true 左右可以滑动
        return false;
    }
}
