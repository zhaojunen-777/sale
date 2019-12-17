package com.atguigu.sale;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Condition1{
    private  int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public synchronized void increment() throws InterruptedException {
//        lock.lock();
        try {
            if (number!=0) {
//                condition.await();
                this.wait();
            }
            ++number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
//            condition.signalAll();
            this.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.unlock();
        }

    }
    public synchronized void decrement() throws InterruptedException {
//        lock.lock();
        try {
            if (number==0) {
//                condition.await();
                this.wait();
            }
            --number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
//            condition.signalAll();
            this.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.unlock();
        }
    }
}
public class Crement {
    public static void main(String[] args) throws Exception {
        Condition1 condition = new Condition1();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    condition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    condition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    condition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    condition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
