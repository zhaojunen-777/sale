package com.atguigu.sale;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number = 30;
    private Lock lock = new ReentrantLock();
    public void sale() {
        lock.lock();
        try {
            if (number>0) {
                System.out.println(Thread.currentThread().getName()+"\t 卖出第："+(number--)+"\t 还剩："+number);
            }
        }finally {
            lock.unlock();
        }
    }
}
public class SaleTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);


                try {
                    for (int i = 0; i <35; i++) {
                        threadPool.execute(()->{t.sale();});
                    }
                }finally {
                    threadPool.shutdown();
                }

//        new Thread(()->{for (int i = 0; i <35 ; i++) t.sale();},"A").start();
//        new Thread(()->{for (int i = 0; i <35 ; i++) t.sale();},"B").start();
//        new Thread(()->{for (int i = 0; i <35 ; i++) t.sale();},"C").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <35 ; i++) {
//                    t.sale();
//                }
//            }
//        },"A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <35 ; i++) {
//                    t.sale();
//                }
//            }
//        },"B").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <35 ; i++) {
//                    t.sale();
//                }
//            }
//        },"C").start();
    }
}
