package com.larscheng.www.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
public class Part01StreamCreateTest {



    /***
     * 创建集合的方式
     * 通过集合
     * 通过数组
     * Stream.of()
     * Stream.iterate() 迭代创建
     * Stream.generate() 生成创建
     */




    //集合创建Stream
    @Test
    public void test1(){
        List<Student> list = StudentData.getList();
        /**
         * 创建一个顺序流（按流的顺序进行中间操作）
         * default Stream<E> stream()
         * {@link Collection#stream()}
         */
        Stream<Student> stream = list.stream();



        /**
         * 创建一个并行流（并行进行中间操作，无顺序）
         * default Stream<E> parallelStream()
         * {@link Collection#parallelStream()}
         */
        Stream<Student> studentStream = list.parallelStream();

    }


    //数组创建Stream
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);

        Student[] students = {new Student(1,"zhang3",15,2000),new Student(2,"li4",25,3000)};
        Stream<Student> stream1 = Arrays.stream(students);

    }

    //Stream.of() 创建Stream
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    //Stream.iterate() 迭代创建
    @Test
    public void test4(){
        //创建前10个偶数
        Stream.iterate(1,t->t+2).limit(10).forEach(System.out::println);
    }

    //Stream.generate() 生成创建
    @Test
    public void test5(){
        //生成十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
