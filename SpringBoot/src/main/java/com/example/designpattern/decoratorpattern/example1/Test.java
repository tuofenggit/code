package com.example.designpattern.decoratorpattern.example1;

public class Test {

    public static void main(String[] args) {

        Walk walk = new WalkImpl();

        Walk walk1 = new Jump(walk);
        Walk walk2 = new Hop(walk);
        walk1.run();
        walk2.run();

    }
}
