package com.atguigu.sale;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> {System.out.println("集齐七颗");});
        for (int i = 1; i <= 7 ; i++) {
            final int temp = i;
            new Thread(()->{

                try {
                    System.out.println(Thread.currentThread().getName()+"\t 集齐第"+temp+"颗龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }
    }
}
