package com.atguigu.sale;

import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized void sendEmali() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Email");
    }
    public synchronized void sendSMS() throws Exception {
        System.out.println("SMS");
    }
    public void say() {
        System.out.println("Hello");
    }
}
public class Lock8 {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmali();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"A").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
                //phone.sendSMS();
                phone2.sendSMS();
            }catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                phone.say();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"C").start();
    }
}
