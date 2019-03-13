package com.reco.learnjava.thread.future;
/**
 * http://blog.csdn.net/ghsau/article/details/7451464
 *  Java�߳�(��)��Callable��Future
 */
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(
        		new Callable<Integer>() {
        			public Integer call() throws Exception {
        				Thread.sleep(2000);
        				System.out.println("");
        				return new Random().nextInt(100);
        			}
        });
        try {
        	System.out.println("do something");
            //Thread.sleep(4000);// ������һЩ����
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}