package com.larscheng.www.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 将文件中的数据读出并打印
 */
public class NIOFileChannel02 {
    public static void main(String[] args) {
        File file = new File("./hello.txt");
        try (
                // 创建文件输入流
                FileInputStream fileInputStream = new FileInputStream(file);
                // 获取文件通道
                FileChannel fileChannel = fileInputStream.getChannel()
        ) {
            // 创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
            // 读入通道
            fileChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
