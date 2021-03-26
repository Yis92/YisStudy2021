package com.yis.study.shujujiegou.danli;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

/**
 * Created by liuyi on 2021-03-26.
 */
public class DanliStudyActivity {

    // 饿汉 线程安全，但是影响性能
    public static final DanliStudyActivity mDanliStudyActivity = new DanliStudyActivity();

    public static DanliStudyActivity getDanliStudyActivity() {
        return mDanliStudyActivity;
    }

    //懒汉 线程不安全
    public static DanliStudyActivity mDanliStudyActivity2;

    public static DanliStudyActivity getDanliStudyActivity2() {
        if (mDanliStudyActivity2 == null) {
            mDanliStudyActivity2 = new DanliStudyActivity();
        }
        return mDanliStudyActivity2;
    }

    //懒汉 线程安全 性能不足
    public static DanliStudyActivity mDanliStudyActivity3;

    public static synchronized DanliStudyActivity getDanliStudyActivity3() {
        if (mDanliStudyActivity3 == null) {
            mDanliStudyActivity3 = new DanliStudyActivity();
        }
        return mDanliStudyActivity3;
    }

    // DCL 双检查锁机制 线程安全 性能足
    // volatile 作用，禁止指令重排序
    // 如果 mDanliStudyActivity4 == null 第二个判断里new 对象的时候，先执行了内存对象指向分配的地址
    // 那么第一个 mDanliStudyActivity4 == null 判断就会认为对象已经创建了，然后其实并没有创建
    public volatile static DanliStudyActivity mDanliStudyActivity4;

    public static DanliStudyActivity getDanliStudyActivity4() {
        // 避免不必要的同步，如果 mDanliStudyActivity4 不为空时，就不用去做同步操作
        if (mDanliStudyActivity4 == null) {
            synchronized (DanliStudyActivity.class) {
                // 如果线程1进入了同步方法，线程2在 synchronized 外等待，
                // 当1结束后，2进来时如果不加判断就会重复new 对象
                if (mDanliStudyActivity4 == null) {
                    mDanliStudyActivity4 = new DanliStudyActivity();
                }
            }
        }
        return mDanliStudyActivity4;
    }
}
