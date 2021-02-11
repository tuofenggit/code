package com.example.designpattern.decoratorpattern.example1;

/**
 * 单足蹦
 */
public class Hop extends Decorator {
    public Hop(Walk walk) {
        super(walk);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("蹦...");
    }
}
