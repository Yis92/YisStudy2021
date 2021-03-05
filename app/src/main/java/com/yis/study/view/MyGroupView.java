package com.yis.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Created by liuyi on 2021-03-01.
 */
public class MyGroupView extends LinearLayout {

    public MyGroupView(Context context) {
        super(context);
    }

    public MyGroupView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroupView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyGroupView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("qqq", "ViewGroup 的 dispatchTouchEvent。。。按下");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("qqq", "ViewGroup 的 dispatchTouchEvent。。。抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("qqq", "ViewGroup 的 dispatchTouchEvent。。。移动");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("qqq", "ViewGroup 的 onInterceptTouchEvent。。。按下");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("qqq", "ViewGroup 的 onInterceptTouchEvent。。。抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("qqq", "ViewGroup 的 onInterceptTouchEvent。。。移动");
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("qqq", "ViewGroup 的 onTouchEvent。。。按下");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("qqq", "ViewGroup 的 onTouchEvent。。。抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("qqq", "ViewGroup 的 onTouchEvent。。。移动");
                break;
        }
        return super.onTouchEvent(event);
    }
}
