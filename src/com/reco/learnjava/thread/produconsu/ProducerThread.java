package com.reco.learnjava.thread.produconsu;

public class ProducerThread implements Runnable {
	ProductStore productStore = new ProductStore();
	private String name;
	public ProducerThread(ProductStore productStore, String name){
		this.productStore = productStore;
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			productStore.produce();
			if(name != null){
				System.out.println("producer "+name+" producer once");
			}
		}
	}

}
