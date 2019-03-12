package com.reco.learnjava.thread;
/**
 * http://www.jianshu.com/p/40d4c7aebd66
 * http://www.importnew.com/21136.html
 * Java中的多线程
 * @author Administrator
 *
 */
public class SyncFuncMainTest {
	public static void main(String[] args) {
		ProductStore productStore = new ProductStore();
		ProducerThread producer1 = new ProducerThread(productStore, "p1");
		ProducerThread producer2 = new ProducerThread(productStore, "p2");
		ConsumerThread consumer1 = new ConsumerThread(productStore, "c1");
		Thread p1 = new Thread(producer1);
		Thread p2 = new Thread(producer2);
		Thread c1 = new Thread(consumer1);
		
		p1.start();
		//p2.start();
		c1.start();
	}
}
