package com.and.geekjava36unit.nineteen;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: [java类作用描述]
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/16 20:52
 */
public class LatchSample {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }

        while (latch.getCount() != 1) {
            Thread.sleep(100L);
        }
        System.out.println("wait for first batch finish");
        latch.countDown();
    }
}

class FirstBatchWorker implements Runnable {
    private CountDownLatch latch;
    public FirstBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("First batch executed");
        latch.countDown();
    }
}

class SecondBatchWorker implements Runnable {
    private CountDownLatch latch;
    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            latch.wait();
            System.out.println("Second batch executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
