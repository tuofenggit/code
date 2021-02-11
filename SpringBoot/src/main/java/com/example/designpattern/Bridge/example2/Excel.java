package com.example.designpattern.Bridge.example2;

public class Excel extends AbstractWordWrite {
    protected Excel(WordWrite wordWrite) {
        super(wordWrite);
    }

    @Override
    public void print() {
        System.out.println("实现excel");
        wordWrite.print();
    }
}
