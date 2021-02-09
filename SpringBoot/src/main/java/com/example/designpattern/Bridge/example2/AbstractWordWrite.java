package com.example.designpattern.Bridge.example2;

public abstract class AbstractWordWrite {

    ColorWrite colorWrite;

    FontWrite fontWrite;

    protected AbstractWordWrite(ColorWrite colorWrite) {
        this.colorWrite = colorWrite;
    }

    protected AbstractWordWrite(FontWrite fontWrite) {
        this.fontWrite = fontWrite;
    }

    protected AbstractWordWrite(ColorWrite colorWrite, FontWrite fontWrite) {
        this.colorWrite = colorWrite;
        this.fontWrite = fontWrite;
    }

    public abstract void print();

}
