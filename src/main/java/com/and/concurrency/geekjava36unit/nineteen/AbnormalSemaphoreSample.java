package com.and.concurrency.geekjava36unit.nineteen;

import java.util.concurrent.Semaphore;

/**
 * @Description: 实现5个人上一辆客车。
 * 我们可以看出 Semaphore 就是个计数器，其基本逻辑基于 acquire/release，并没 有太复杂的同步逻辑
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/16 20:42
 */
public class AbnormalSemaphoreSample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("Action...GO!");
        // 有5个座位
        semaphore.release(5);
        // 开始接客了
        System.out.println("Wait for permits off");
        // 判断Semaphore对象中当前可用的permits个数是否为0
        while (semaphore.availablePermits() != 0) {
            // 不为0则等待其他乘客，直到坐满为止
            Thread.sleep(100L);
        }
        // 坐满了，出发
        System.out.println("Action...GO again!");
        // 释放信号量
        semaphore.release(5);
    }
}

class MyWorker implements Runnable {
    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
