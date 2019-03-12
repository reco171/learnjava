package com.reco.learnjava.thread;

/*
 * 多个线程分别对变量写读
*/
import java.util.Random;

public class TestWriteReadRand {
	private  int number = 1;
	private  Object object = new Object();
	public static void main(String[] args) {
		TestWriteReadRand testObject = new TestWriteReadRand();
		Thread thread1 = testObject.new WriteThread();
		Thread thread3 = testObject.new WriteThread();
		Thread thread2 = testObject.new ReadThread();
		thread1.setName("writeThread1");
		thread3.setName("writeThread2");
		thread2.setName("readThread1");
		thread1.start();
		//thread3.start();
		thread2.start();
	}
	class WriteThread extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				number = new Random().nextInt(6) + 1;
				System.out.print("线程: "+Thread.currentThread().getName());
				System.out.println(" number set to "+number);
			}
		}
	}
	class ReadThread extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程: "+Thread.currentThread().getName());
				if(number == 3){
					try {
						System.out.println("*************************");
						System.out.println("find number equals 3");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					//System.out.println("number = "+number);
				}
			}
		}
	}
}
