package com.yis.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by liuyi on 2021-03-03.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("qqq", "view 的 dispatchTouchEvent。。。按下");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("qqq", "view 的 dispatchTouchEvent。。。抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("qqq", "view 的 dispatchTouchEvent。。。移动");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("qqq", "view 的 onTouchEvent。。。按下");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("qqq", "view 的 onTouchEvent。。。抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("qqq", "view 的 onTouchEvent。。。移动");
                break;
        }
        return super.onTouchEvent(event);
    }
}
