package com.yis.study.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyi on 2021-03-23.
 */
public class SynchronizedMethod {

    // 锁的是对象
    private Object obj = new Object();
    // 锁的类
    private static Object obj2 = new Object();

    /**
     * 锁对象
     */
    public synchronized void obj1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + "qqq i==" + i);
        }
    }

    /**
     * 锁对象
     */
    public void obj2() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "qqq i==" + i);
            }
        }
    }

    /**
     * 锁对象
     */
    public void obj3() {
        synchronized (obj) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "qqq i==" + i);
            }
        }
    }

    /**
     * 锁类
     */
    public static synchronized void class1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + "qqq i==" + i);
        }
    }

    /**
     * 锁类
     */
    public void class2() {
        synchronized (obj2) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "qqq i==" + i);
            }
        }
    }

    /**
     * 锁类
     */
    public void class3() {
        synchronized (SynchronizedMethod.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "qqq i==" + i);
            }
        }
    }

}
