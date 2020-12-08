package com.lgp.drools.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class Queue {
    static ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 1000000; i++) {
            map.put("hashKey" + i, i + "vvvvv");
        }

        for (int i = 0; i < 10; i++) {
            long time = System.currentTimeMillis();
            System.out.println(map.get("hashKey505"));
            System.out.println("耗时：" + (System.currentTimeMillis() - time) + " ms");
        }


    }

}
