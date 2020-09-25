package com.larscheng.www.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author larscheng
 */
public class GroupChatServer {
    /**
     * 选择器
     */
    private Selector selector;
    /**
     * 服务端通道
     */
    private ServerSocketChannel listenChannel;
    /**
     * 服务端端口
     */
    private static final int PORT = 9098;

    /**
     * 构造器初始化
     */
    public GroupChatServer() {
        try {
            // 获取选择器
            selector = Selector.open();
            // 创建通道
            listenChannel = ServerSocketChannel.open();
            // 绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            // 设置非阻塞模式
            listenChannel.configureBlocking(false);
            // 将通道注册到选择器
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        System.out.println("服务端开始监听..........");
        while (true) {
            try {
                int count = selector.select();
                if (count > 0) {
                    // 遍历发生事件的通道key
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        // accept事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            // 将该通道注册到选择器
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress() + " 上线了 ");
                        }
                        // 通道发生read事件
                        if (key.isReadable()) {
                            // 处理读事件
                            read(key);
                        }
                        // 删除当前的key，防止重复处理
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待连接中.....");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 读取客户端发送的消息
     *
     * @param key 通道key
     */
    private void read(SelectionKey key) {

        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 读取通道中的数据
            int read = channel.read(buffer);
            if (read > 0) {
                // 把缓冲区的数据转成字符串
                String msg = new String(buffer.array());
                // 输出
                System.out.println("接收到客户端 "+ channel.getRemoteAddress() + " 的信息: " + msg);
                // 向其他的客户端广播本消息
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了 ");
                key.cancel();
                channel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 转发消息给其他客户端
     */
    private void sendInfoToOtherClients(String msg, SocketChannel channel) {
        System.out.println("服务器转发消息中.....");
        // 遍历 所有注册到selector上的通道，并将发送者排除
        for (SelectionKey key : selector.keys()) {
            // 通过 key 取出对应的SocketChannel
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                SocketChannel dest = (SocketChannel) targetChannel;
                // 将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                // 将buffer的数据写入通道
                try {
                    dest.write(buffer);
                    System.out.println("信息转发成功....");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        final GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
