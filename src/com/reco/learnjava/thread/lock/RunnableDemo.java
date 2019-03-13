package com.reco.learnjava.thread.lock;
/**
 * Java并发编程：Lock
 * https://www.cnblogs.com/fuck1/p/5432806.html
 * @author Administrator
 *
 */
public class RunnableDemo {
    public static void main(String[] args) {
        SellTicket str = new SellTicket();
        
        Thread tr1 = new Thread(str, "窗口1");
        Thread tr2 = new Thread(str, "窗口2");
        Thread tr3 = new Thread(str, "窗口3");
        
        //
        tr1.start();
        tr2.start();
        tr3.start();
    }
}