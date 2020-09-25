package com.larscheng.www.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOSelectorClient {
    public static void main(String[] args) throws IOException {
        // 创建一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞
        socketChannel.configureBlocking(false);
        // 连接服务器
        if (!socketChannel.connect(new InetSocketAddress(8888))){
            while(!socketChannel.finishConnect()){
                System.out.println("client connecting ，pls wait .......... ");
            }
        }
        System.out.println("client connect success!");
        String msg = "Hello World!";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        // 将缓冲区中的数据写入通道
        socketChannel.write(buffer);
        System.in.read();
    }
}
