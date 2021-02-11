package com.example.designpattern.decoratorpattern.example1;

public class Decorator implements Walk {

    Walk walk;

    public Decorator(Walk walk) {
        this.walk = walk;
    }

    @Override
    public void run() {
        walk.run();
    }
}
