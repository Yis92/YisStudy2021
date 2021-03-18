package com.yis.study.thread;

import androidx.annotation.Nullable;

import java.lang.reflect.Proxy;


/**
 * Created by liuyi on 2021-03-12.
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        @Nullable
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>() {

        @Nullable
        @Override
        protected String initialValue() {
            return "you";
        }
    };

    /**
     * 同时运行三个线程
     */
    public void startArrayThread() {
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new TestThread(i));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

    }

    /**
     * 获取当前integerThreadLocal的值，然后将threadloacl的值改变，并写回
     */
    private class TestThread implements Runnable {

        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            //输出当前线程的名称
            System.out.println(Thread.currentThread().getName() + "---start");

            String type = stringThreadLocal.get();

            int newId = integerThreadLocal.get();//这里得到值永远都是初始化的那个值，每个线程拿到的都是一个副本，自己玩自己的，隔离开了
            System.out.println(Thread.currentThread().getName() + "----integer ThreadLocal get   " + integerThreadLocal.get());
            System.out.println(Thread.currentThread().getName() + "----string ThreadLocal get   " + stringThreadLocal.get());

            newId = newId + id;//此处由于id的值是变化的所以newId才会跟着变化

            integerThreadLocal.set(newId);

            stringThreadLocal.set(type + id);

            System.out.println(Thread.currentThread().getName() + "----integer ThreadLocal set后  " + integerThreadLocal.get());
            System.out.println(Thread.currentThread().getName() + "----string ThreadLocal set后  " + stringThreadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest localTest = new ThreadLocalTest();
        localTest.startArrayThread();

    }


}
