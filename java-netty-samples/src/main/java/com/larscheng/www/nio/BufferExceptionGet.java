package com.larscheng.www.nio;

import java.nio.ByteBuffer;

public class BufferExceptionGet {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.putInt(1);
        byteBuffer.putChar('a');
        byteBuffer.putLong(123L);
        byteBuffer.putShort((short)5);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getLong());//BufferUnderflowException
    }
}
