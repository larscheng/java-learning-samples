package com.larscheng.www.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author zhengql
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        // 1.创建一个线程池
        // 2.如果有客户端连接就创建一个线程与之通讯

        // 线程池处理客户端
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),(r) -> new Thread(r,"pool-socket"));
        // 创建SocketServer
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务已启动.......");

        while (true) {
            // 阻塞！！！！等待连接
            System.out.println("等待客户端接入.......阻塞中........");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executor.execute(() -> handler(socket));
        }
    }

    /**
     * 处理客户端请求
     * @param socket
     */
    public static void handler(Socket socket) {
        byte[] b = new byte[1024];
        try {
            System.out.println("线程id: " + Thread.currentThread().getId());
            InputStream inputStream = socket.getInputStream();
            while (true) {
                // 阻塞！！！！等待读取
                System.out.println("等待读取数据......阻塞中..........");
                int read = inputStream.read(b);
                if (read != -1) {
                    System.out.println(new String(b, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
