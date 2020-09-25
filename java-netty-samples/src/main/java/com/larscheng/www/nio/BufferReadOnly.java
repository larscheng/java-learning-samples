package com.larscheng.www.nio;

import java.nio.ByteBuffer;

public class BufferReadOnly {
    public static void main(String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(32);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        buffer.flip();
        // 转换为只读缓冲区
        final ByteBuffer byteBuffer = buffer.asReadOnlyBuffer();
        System.out.println(byteBuffer.getClass());

        // 来读只读缓冲区
        while(byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
        // 对只读缓冲区进行写入
        byteBuffer.put((byte)100);
    }
}
