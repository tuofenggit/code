package com.example.designpattern.decoratorpattern.example1;

public class Jump extends Decorator {
    public Jump(Walk walk) {
        super(walk);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("跳....");
    }
}
