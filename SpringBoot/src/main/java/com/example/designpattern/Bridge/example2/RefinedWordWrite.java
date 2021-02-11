package com.example.designpattern.Bridge.example2;

/**
 * 两个维度 各自独立, 减少耦合度
 */
public class RefinedWordWrite extends AbstractWordWrite {


    protected RefinedWordWrite(WordWrite wordWrite) {
        super(wordWrite);
    }

    @Override
    public void print() {
        System.out.println("实现输出");
        wordWrite.print();

    }
}
