package com.larscheng.www.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOMappedByteBuffer {
    public static void main(String[] args) throws Exception {

        try (
                final RandomAccessFile rw = new RandomAccessFile("./hello.txt", "rw");
                final FileChannel channel = rw.getChannel();
        ) {
            /**
             * MapMode mode,模式
             * long position, 开始位置
             * long size,映射到内存的大小（不是索引），将文件中的具体大小数据映射到内存，以供直接修改
             */
            final MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
            mappedByteBuffer.put(0, (byte) 'H');
            mappedByteBuffer.put(6, (byte) 'W');//超过了大小5，抛出异常IndexOutOfBoundsException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
