package com.larscheng.www.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOSelectorServer {
    public static void main(String[] args) throws IOException {
        // 创建服务端的ServerSocketChannel，用来客户端建立连接后生成SocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 得到一个Selector
        Selector selector = Selector.open();
        // 服务端监听端口8888
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        // 设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 注册ServerSocketChannel到Selector上，开始监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 循环等待客户端连接
        while (true){
            // 检测通道中是否有OP_ACCEPT事件发生，阻塞时间1s
            if (selector.select(1000)==0){
                System.out.println("Server wait 1s ....");
                continue;
            }
            // selector.select大于0 表示检测到通道中发生事件，获取selectionKeys
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                // 获取key
                SelectionKey key = keyIterator.next();
                // 根据key对应的通道事件进行处理
                if (key.isAcceptable()){
                    //连接事件，与客户端建立SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("Client connected... "+socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    // 将通道注册到selector，关注OP_READ事件
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()){
                    SocketChannel channel = (SocketChannel)key.channel();
                    // 获取到该通道对应的缓冲区buffer
                    ByteBuffer buffer =  (ByteBuffer)key.attachment();
                    // 通道内数据读入缓冲区
                    channel.read(buffer);
                    System.out.println("receive msg : "+ new String(buffer.array()));
                }
                //处理操作结束，移除key
                keyIterator.remove();
            }

        }
    }
}
