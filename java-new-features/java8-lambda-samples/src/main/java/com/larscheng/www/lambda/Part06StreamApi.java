package com.larscheng.www.lambda;

import org.junit.Test;

/***
 * Stream API 关注对数据的运算，属于CPU密集型
 * Collections 关注对数据的存储，属于IO密集型
 *
 * Stream 自己本身不存储元素
 * Stream 不会改变元对象，但是他会返回一个持有结果的新Stream
 * Stream 操作是延时执行的，意味着需要结果时才执行
 *
 * 执行流程： 实例化 ==> 中间操作 ==> 终止操作
 *
 * 中间操作往往是一个操作链
 * 一旦终止操作，就执行中间操作链，并产生结果。【延时执行，终止操作触发执行】
 *
 */
public class Part06StreamApi {



    /***
     * 创建集合的方式
     * 通过集合
     */
    @Test
    public void test1(){

    }
}
