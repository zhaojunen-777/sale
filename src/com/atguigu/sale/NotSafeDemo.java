package com.atguigu.sale;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NotSafeDemo {
    public static void main(String[] args) {
//        Set<String> set = new CopyOnWriteArraySet();//Collections.synchronizedSet(new HashSet<>());
//        for (int i = 1; i <= 30; i++) {
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,6));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//        }
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,6));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
