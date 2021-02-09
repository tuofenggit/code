package com.example.designpattern.Bridge.example2;

public class ColorWrite implements WordWrite {

    private String fontColor;

    public ColorWrite(String fontColor) {
        this.fontColor = fontColor;
    }

    @Override
    public void print() {
        System.out.println("设置颜色:" + fontColor);
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }
}
