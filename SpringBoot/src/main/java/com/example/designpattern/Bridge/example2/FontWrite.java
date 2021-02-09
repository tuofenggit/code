package com.example.designpattern.Bridge.example2;

public class FontWrite implements WordWrite {
    public String fontSize;

    public FontWrite(String fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public void print() {
        System.out.println("设置具体字号:"+fontSize);
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }
}
