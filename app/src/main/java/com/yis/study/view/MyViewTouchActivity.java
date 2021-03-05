package com.yis.study.view;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

/**
 * 事件分发学习整理
 * Created by liuyi on 2021-03-03.
 */
public class MyViewTouchActivity extends BaseActivity {

    private MyView myView;
    private MyGroupView myGroupView;
    private MyView myViewChild;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_view_touch;
    }

    @Override
    protected void initData() {
        myView = findViewById(R.id.my_view);
        myGroupView = findViewById(R.id.my_group_view);
        myViewChild = findViewById(R.id.my_view_child);

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("qqq", "MyView setOnClickListener。。。");
            }
        });

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("qqq", "MyView setOnTouchListener。。。" + event.getAction());
                return true;
            }
        });

        myGroupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("qqq", "MyGroupView setOnClickListener。。。");
            }
        });

        myViewChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("qqq", "MyViewChild setOnClickListener。。。");
            }
        });

//        myGroupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.i("qqq", "MyGroupView setOnTouchListener。。。" + event.getAction());
//                return true;
//            }
//        });

//        btnChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("qqq", "child setOnClickListener。。。。");
//            }
//        });

    }
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.i("qqq", "Activity 的 dispatchTouchEvent。。。按下");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.i("qqq", "Activity 的 dispatchTouchEvent。。。抬起");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.i("qqq", "Activity 的 dispatchTouchEvent。。。移动");
//                break;
//        }
//        return super.dispatchTouchEvent(event);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.i("qqq", "Activity 的 onTouchEvent。。。按下");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.i("qqq", "Activity 的 onTouchEvent。。。抬起");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.i("qqq", "Activity 的 onTouchEvent。。。移动");
//                break;
//        }
//        return super.onTouchEvent(event);
//    }

}
