package com.atguigu.sale;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share {
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5() throws InterruptedException {
        lock.lock();
        try {
           if (flag != 1){
               c1.await();
           }
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            flag = 2;
            c2.signal();
        }finally {
            lock.unlock();
        }
    }
    public void print10() throws InterruptedException {
        lock.lock();
        try {
            if (flag != 2){
                c2.await();
            }
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            flag = 3;
            c3.signal();
        }finally {
            lock.unlock();
        }
    }
    public void print15() throws InterruptedException {
        lock.lock();
        try {
            if (flag != 3){
                c3.await();
            }
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            flag = 1;
            c1.signal();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadOrderAccess {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.print5();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.print10();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.print15();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}
