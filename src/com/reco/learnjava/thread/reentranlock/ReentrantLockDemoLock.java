package com.reco.learnjava.thread.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemoLock implements Runnable {

    private Lock lock = new ReentrantLock();

    private int tickets = 200;

    @Override
    public void run() {
        while (true) {
            lock.lock(); // 获取锁
            try {
                if (tickets > 0) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " " + tickets--);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 释放所
            }
        }
    }

    public static void main(String[] args) {
    	ReentrantLockDemoLock reentrantLockDemo = new ReentrantLockDemoLock();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(reentrantLockDemo, "thread" + i);
            thread.start();
        }
    }

}
