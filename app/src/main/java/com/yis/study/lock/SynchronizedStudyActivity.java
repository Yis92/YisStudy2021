package com.yis.study.lock;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyi on 2021-03-23.
 */
public class SynchronizedStudyActivity {

    // 公平锁
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        SynchronizedMethod method1 = new SynchronizedMethod();
        SynchronizedMethod method2 = new SynchronizedMethod();

        // 1、
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 锁对象
//                method1.obj1();
//                method1.obj2();
//                method1.obj3();
//
//                // 锁类
//                SynchronizedMethod.class1();
//                method1.class2();
                method1.class3();
            }
        });

        // 2、
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 锁对象
//                method2.obj1();
//                method2.obj2();
//                method2.obj3();
//
//                // 锁类
//                SynchronizedMethod.class1();
//                method2.class2();
                method2.class3();
            }
        });

        thread1.start();
        thread2.start();

        // 3、公平锁

    }


}
