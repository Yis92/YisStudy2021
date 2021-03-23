package com.yis.study.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyi on 2021-03-23.
 */
public class ReentrantLockDemo {

    // 公平锁
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public void test() {

        for (int i = 0; i < 5; i++) {
            reentrantLock.lock();
            try {

                System.out.println(Thread.currentThread() + "qqq i==" + i);

            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        ReentrantLockDemo demo1 = new ReentrantLockDemo();
        ReentrantLockDemo demo2 = new ReentrantLockDemo();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo1.test();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo2.test();
            }
        });

        thread1.start();
        thread2.start();

    }
}
