package com.example.designpattern.Bridge.example2;

public class RefinedWordWrite extends AbstractWordWrite {

    protected RefinedWordWrite(ColorWrite colorWrite, FontWrite fontWrite) {
        super(colorWrite, fontWrite);
    }

    @Override
    public void print() {
        System.out.println("实现输出");
        //设置默认字号
        if (fontWrite == null) {
            fontWrite = new FontWrite("12");
        }
        fontWrite.print();
        //设置默认颜色
        if (colorWrite == null) {
            colorWrite = new ColorWrite("黑色");
        }
        colorWrite.print();

    }
}
