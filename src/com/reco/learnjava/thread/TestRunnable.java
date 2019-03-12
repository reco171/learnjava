package com.reco.learnjava.thread;

public class TestRunnable implements Runnable{
	private int ticket=10;  
	public void run(){  
		for(int i=0;i<20;i++){  
			if(this.ticket>0){
				System.out.print("线程 ："+Thread.currentThread().getName());  
				System.out.println("卖票：ticket"+this.ticket--);  
			}  
		}  
	}  
	public static void main(String[] args) {
		TestRunnable mt=new TestRunnable();  
		new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一  
		new Thread(mt).start();//个实例化对象mt，就会出现异常  
		new Thread(mt).start();  
	}
}

