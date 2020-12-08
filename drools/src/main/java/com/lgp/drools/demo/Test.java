package com.lgp.drools.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10, TimeUnit.SECONDS, new SynchronousQueue<>(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {

        add("1","一");
        add("2","二");
        add("2","二.1");
        add("2","二.2");
        add("3","三");
        add("4","四");
        add("1","一一");
        add("1","一一一");
        add("1","一一一一");


        executor.shutdown();


    }

    public static void add(String name,String value) {
        if (MyThread.MAP.containsKey(name)) {
            while (MyThread.MAP.containsKey(name)) {

            }
            MyThread.MAP.put(name, "");
            System.out.println("获取到：" + value);
            Thread thread = new MyThread(name,value);
            executor.execute(thread);

        } else {
            MyThread.MAP.put(name, "");
            Thread thread = new MyThread(name,value);
            executor.execute(thread);
        }


    }


}

class MyThread extends Thread {

    public static final ConcurrentHashMap<String, String> MAP = new ConcurrentHashMap<>();

    public MyThread(String tname, String tvalue) {
        this.tname = tname;
        this.tvalue = tvalue;
    }

    private String tname;
    private String tvalue;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTvalue() {
        return tvalue;
    }

    public void setTvalue(String tvalue) {
        this.tvalue = tvalue;
    }

    @Override
    public void run() {

        System.out.println(tvalue + "开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tvalue + "结束******************");
        MAP.remove(tname);
    }
}