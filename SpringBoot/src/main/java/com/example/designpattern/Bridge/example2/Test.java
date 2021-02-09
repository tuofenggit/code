package com.example.designpattern.Bridge.example2;

public class Test {

    public static void main(String[] args) {
        ColorWrite colorWrite = new ColorWrite("绿色");
        FontWrite fontWrite = new FontWrite("13");

        RefinedWordWrite write = new RefinedWordWrite(colorWrite, null);
        write.print();

    }
}
