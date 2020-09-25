package com.larscheng.www.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从文件1中读出，再写入文件2
 */
public class NIOFileChannel03 {
    public static void main(String[] args) {

        try (
                FileInputStream fileInputStream = new FileInputStream("./hello.txt");
                FileChannel fileChannel1 = fileInputStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream("./hello-world.txt");
                FileChannel fileChannel2 = fileOutputStream.getChannel()
        ) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 不知道有多少数据，循环读写，直到读完break
            while(true){
                byteBuffer.clear();
                // 将通道内数据读入缓冲区
                int read = fileChannel1.read(byteBuffer);
                if (read==-1){
                    break;// 读完了
                }
                // 反转缓冲区，准备读缓冲区
                byteBuffer.flip();
                fileChannel2.write(byteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
