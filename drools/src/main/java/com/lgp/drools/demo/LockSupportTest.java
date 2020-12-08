package com.lgp.drools.demo;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public final static ConcurrentHashMap<String, ConcurrentLinkedQueue<MyThread>> MAP = new ConcurrentHashMap<String, ConcurrentLinkedQueue<MyThread>>();

    public static void main(String[] args) {


        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread(thread);
        thread.start();
        thread1.start();
        LockSupport.unpark(thread1);
    }

    static class MyThread extends Thread {

        MyThread myThread;

        public MyThread(MyThread myThread) {
            this.myThread = myThread;
        }

        public MyThread() {
        }

        @Override
        public void run() {

            System.out.println("1");

            LockSupport.unpark(myThread);
            LockSupport.park();
            System.out.println("2");

        }
    }
}


