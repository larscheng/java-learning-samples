package com.larscheng.www.nio;

import java.nio.IntBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 写
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i+1);
        }
        // 读写切换
        intBuffer.flip();
        // 读
        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
        System.out.println("------------");

        /**
         * clear 各属性恢复默认值
         *         position = 0;
         *         limit = capacity;
         *         mark = -1;
         *flip 翻转，用于由写入结束后，开始读取前的操作，限定limit的值
         *         position = 0;
         *         limit = position;
         *         mark = -1;
         *rewind 用于重绕缓冲区，将位置属性恢复默认
         *         position = 0;
         *         mark = -1;
         */
        intBuffer.rewind();
        intBuffer.limit(3);//可读取的位置仅剩0、1、2
        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
