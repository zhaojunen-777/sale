package com.atguigu.sale;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }
}
