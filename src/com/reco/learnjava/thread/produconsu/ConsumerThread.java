package com.reco.learnjava.thread.produconsu;

public class ConsumerThread implements Runnable {
	ProductStore productStore = new ProductStore();
	private String name;
	public ConsumerThread(ProductStore productStore, String name){
		this.productStore = productStore;
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			productStore.consume();
			if(name != null){
				System.out.println("consumer "+name+" consume once");
			}
		}
	}


}
