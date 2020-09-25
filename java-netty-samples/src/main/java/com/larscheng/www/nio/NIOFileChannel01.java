package com.larscheng.www.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/***
 * 将字符串写入到本地文件
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        String msg = "hello world!";
        try (
                // 创建文件输出流
                FileOutputStream fileOutputStream = new FileOutputStream("./hello.txt");
                // 获取文件通道
                FileChannel fileChannel = fileOutputStream.getChannel();
        ) {
            // 创建缓冲区ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //写入字符串到缓冲区
            buffer.put(msg.getBytes());
            //准备将缓冲区中的数据写入到通道中
            buffer.flip();
            //写入到通道
            fileChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
