package com.example.designpattern.Bridge.example2;

public abstract class AbstractWordWrite {

    WordWrite wordWrite;


    protected AbstractWordWrite(WordWrite wordWrite) {
        this.wordWrite = wordWrite;
    }


    public abstract void print();

}
