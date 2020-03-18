package com.and.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: [java类作用描述]
 * @Author: jiangzhihong
 * @CreateDate: 2020/2/22 22:51
 */
public class Test {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> testsync());
        t1.setName("t1");

        Thread t2 = new Thread(() -> testsync());
        t2.setName("t2");

        t1.start();
        t2.start();
    }


    /**
     * 同步方法
     */
    public static void testsync() {
        ReentrantLock reentrantLock = new ReentrantLock();
        // 为什么有synchronized还要有ReentrantLock
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
