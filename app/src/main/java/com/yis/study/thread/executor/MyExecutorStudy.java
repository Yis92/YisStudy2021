package com.yis.study.thread.executor;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyi on 2021-03-23.
 */
public class MyExecutorStudy {

    public static void main(String[] args) throws InterruptedException {

        // 1、创建单线程
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//
//        for (int i = 0; i < 5; i++) {
//            final int taskId = i;
//            singleThreadExecutor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("正在执行" + Thread.currentThread().getName() + "任务=" + taskId);
//                }
//            });
//            Thread.sleep(1000);
//        }

        // 2、创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            final int taskId = i;
//
//            cachedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("正在执行" + Thread.currentThread().getName() + "任务=" + taskId);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        cachedThreadPool.shutdown();

        // 3、创建一个固定数目的、可重用的线程池。
//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int taskId = i;
//
//            newFixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("正在执行" + Thread.currentThread().getName() + "任务=" + taskId);
//                }
//            });
//        }

        // 4、创建一个定时线程池，支持定时及周期性任务执行
        // 指定线程数量为2的定时任务线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        // 延迟1s执行，每隔1s执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();

                System.out.println("正在执行" + Thread.currentThread().getName() + "报时=" + date);
            }
        },500,500, TimeUnit.MILLISECONDS);

        Thread.sleep(5000);
        // 使用 shutdown 关闭服务
        scheduledExecutorService.shutdown();

    }
}
