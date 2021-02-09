package com.example.web.controller.nio;


import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        intBuffer.flip();
        for (int i = 0; i < intBuffer.capacity(); i++) {
            System.out.println("result:" + intBuffer.get());
        }


    }
}
