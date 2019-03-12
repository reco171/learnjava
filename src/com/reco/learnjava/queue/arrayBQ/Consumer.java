package com.reco.learnjava.queue.arrayBQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * @author zhaogj
 *
 */
public class Consumer implements Runnable{
    
    //容器
    private final ArrayBlockingQueue<Bread> queue;
    
    public Consumer(ArrayBlockingQueue<Bread> queue){
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            consume();
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
    }
    
    public void consume(){
        /**
         * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
         * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
         */
        try {
            Bread bread = queue.take();
            System.out.println("consumer: "+ 
            Thread.currentThread().getName()+" queue size�� "+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}