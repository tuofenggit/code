package com.example.web.controller.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试方式：
 * 启动 BIOServer
 * 通过cmd  telnet  localhost 6666
 * 连接成功以后 使用 Ctrl + ] 键 ，sen  xxxx 即可
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        System.out.println("服务端已启动...");
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {

            final Socket accept = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(accept);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        System.out.println("客户端信息：Id:" + Thread.currentThread().getId() + ",线程名称:" + Thread.currentThread().getName());
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(Thread.currentThread().getName() + "客户端信息:" + new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("客户端已关闭：Id:" + Thread.currentThread().getId() + ",线程名称:" + Thread.currentThread().getName());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
