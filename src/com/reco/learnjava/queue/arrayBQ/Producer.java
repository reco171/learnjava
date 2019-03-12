package com.reco.learnjava.queue.arrayBQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



/**
 * 生产者
 * @author 
 *
 */
public class Producer implements Runnable{
    
    //容器
    private final ArrayBlockingQueue<Bread> queue;
    
    public Producer(ArrayBlockingQueue<Bread> queue){
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            produce();
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
    }
    
    public void produce(){
        /**
         * put()方法是如果容器满了的话就会把当前线程挂起
         * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。
         */
        try {
            Bread bread = new Bread();
            queue.put(bread);
            System.out.println("producer: "+ 
            Thread.currentThread().getName()+" queue size�� "+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}