package com.larscheng.www.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel的transferFrom方法：将目标通道中的数据复制到当前通道中
 */
public class NIOFileChannelCopy {
    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("./hello.txt");
                FileChannel fileChannel1 = fileInputStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream("./hello-copy.txt");
                FileChannel fileChannel2 = fileOutputStream.getChannel()
        ) {
            fileChannel2.transferFrom(fileChannel1,0,fileChannel1.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
