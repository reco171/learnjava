package com.reco.learnjava.thread.reentranlock;
/**
 * zhaogj 可重入锁ReentrantLock，代码参考
 * 可重入锁：ReentrantLock理解使用
 * https://blog.csdn.net/u014730165/article/details/82144848
 * zookeeper可重入锁，InterProcessMutex，参考：
 * 跟着实例学习ZooKeeper的用法： 分布式锁https://yq.aliyun.com/articles/18274
 */
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {
	private Lock lock = new ReentrantLock();

    private Condition addCondition = lock.newCondition();

    private Condition removeCondition = lock.newCondition();

    private LinkedList<Integer> resources = new LinkedList<>();

    private int maxSize;

    public ProducerConsumerTest(int maxSize) {
        this.maxSize = maxSize;
    }


    public class Producer implements Runnable {

        private int proSize;

        private Producer(int proSize) {
            this.proSize = proSize;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i < proSize; i++) {
                    while (resources.size() >= maxSize) {
                        System.out.println("当前仓库已满，等待消费...");
                        try {
                            addCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("已经生产产品数: " + i + "\t现仓储量总量:" + resources.size());
                    resources.add(i);
                    removeCondition.signal();
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public class Consumer implements Runnable {
        private int proSize;
        private Consumer(){}
    	private Consumer(int proSize){
    		this.proSize = proSize-1;
    	}
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            loop:while (true) {
                lock.lock();
                try {
                    while (resources.size() <= 0) {
                        System.out.println(threadName + " 当前仓库没有产品，请稍等...");
                        try {
                            // 进入阻塞状态
                            removeCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 消费数据
                    int size = resources.size();
                    for (int i = 0; i < size; i++) {
                        Integer remove = resources.remove();
                        System.out.println(threadName + " 当前消费产品编号为：" + remove);
                        if(remove == proSize){
                        	break loop;
                        }
                    }

                    // 唤醒生产者
                    addCondition.signal();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerTest producerConsumerTest = new ProducerConsumerTest(10);
        Producer producer = producerConsumerTest.new Producer(100);
        //Consumer consumer = producerConsumerTest.new Consumer();
        Consumer consumer = producerConsumerTest.new Consumer(100);
        final Thread producerThread = new Thread(producer, "producer");
        final Thread consumerThread = new Thread(consumer, "consumer");
        producerThread.start();
        TimeUnit.SECONDS.sleep(2);
        consumerThread.start();
    }

}
