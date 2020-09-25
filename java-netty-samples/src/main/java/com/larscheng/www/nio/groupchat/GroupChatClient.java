package com.larscheng.www.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @author larscheng
 */
public class GroupChatClient {
    // 定义相关的属性

    private final String host = "127.0.0.1";
    private final int port = 9098;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;


    public GroupChatClient() {
        try {
            // 获取选择器
            selector = Selector.open();
            // 获取通道，连接至服务器
            socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
            // 设置非阻塞模式
            socketChannel.configureBlocking(false);
            // 将通道注册到选择器
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + " is ok....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 向服务器发送数据
     *
     * @param msg 消息
     */
    public void sendMsg(String msg) {
        msg = username + " 说 " + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readMsg() {
        try {

            System.out.println(Thread.currentThread().getId()+" 读取信息中.... ");
            int select = selector.select();
            if (select > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        // 根据key获取通道
                        SocketChannel channel = (SocketChannel) key.channel();
                        // 创建一个缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // 读取通道数据到缓冲区
                        channel.read(buffer);
                        // 缓冲区数据输出
                        String msg = new String(buffer.array());
                        System.out.println("收到消息： " + msg.trim());
                    }
                }
                // 删除当前的key， 防止重复操作
                iterator.remove();
            } else {
                System.out.println("没有可用的通道");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final GroupChatClient groupChatClient = new GroupChatClient();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 2000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                (r) -> new Thread(r, "pool-client")
        );
        poolExecutor.execute(() -> {
            while (true) {
                groupChatClient.readMsg();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//
//        //启动一个线程, 每个3秒，读取从服务器发送数据
//        new Thread() {
//            public void run() {
//
//                while (true) {
//                    groupChatClient.readMsg();
//                    try {
//                        Thread.currentThread().sleep(3000);
//                    }catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            groupChatClient.sendMsg(s);
        }
    }
}
