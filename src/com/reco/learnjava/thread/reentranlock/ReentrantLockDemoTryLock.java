package com.reco.learnjava.thread.reentranlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemoTryLock implements Runnable{
	private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " 获取当前lock锁");
                TimeUnit.SECONDS.sleep(4);
            } else {
                System.out.println(Thread.currentThread().getName()+ " 获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
    	ReentrantLockDemoTryLock reentrantLockDemo = new ReentrantLockDemoTryLock();
        Thread thread01 = new Thread(reentrantLockDemo, "thread01");
        Thread thread02 = new Thread(reentrantLockDemo, "thread02");
        thread01.start();
        thread02.start();
    }

}
