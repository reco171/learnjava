package com.reco.learnjava.queue.arrayBQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingQueue {

	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
	        int capacity = 10;
	        ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<Bread>(capacity);
/*	        try {
				queue.put(null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	        new Thread(new Producer(queue)).start();
	        new Thread(new Producer(queue)).start();
	        new Thread(new Consumer(queue)).start();
	        //new Thread(new Consumer(queue)).start();
	        //new Thread(new Consumer(queue)).start();
	    }

	}