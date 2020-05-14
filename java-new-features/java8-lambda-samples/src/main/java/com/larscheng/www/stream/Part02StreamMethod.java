package com.larscheng.www.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream中间操作
 * 1、筛选与切片 filter、limit、skip、distinct
 * 2、映射  map、mapToDouble、mapToInt、mapToLong、flatMap
 * 3、排序 sorted()、sorted(Comparator c)
 */
public class Part02StreamMethod {
    /******1、筛选与切片******/
    @Test
    public void test1() {

        List<Student> list = StudentData.getList();
        Stream<Student> stream = list.stream();
        //filter 筛选
        stream.filter(s -> s.getAge() > 40).forEach(System.out::println);
        System.out.println();
        //limit 截断流，从stream中获取指定大小的stream
        list.stream().limit(4).forEach(System.out::println);
        System.out.println();
        //skip 跳过元素，从stream中跳过指定个数后获取stream
        list.stream().skip(3).forEach(System.out::println);
        /*跳过的个数超过stream中元素个数，返回空流*/
        System.out.println("begin skip(30)");
        list.stream().skip(30).forEach(System.out::println);
        System.out.println("end skip(30)");
        System.out.println();
        //distinct 去重，根据stream中元素自己的hashcode()和equals()
        list.add(new Student(1009, "Tony", 18, 50000));
        list.add(new Student(1009, "Tony", 19, 50000));
        list.add(new Student(1009, "Tony", 18, 50000));
        list.add(new Student(1009, "Tony", 18, 50000));
        list.stream().distinct().forEach(System.out::println);
    }

    /******2、映射******/
    @Test
    public void test2() {
        List<Student> list = StudentData.getList();
        //map(Function f) 接受一个函数作为参数，将元素转换成其他形式，或者提取信息，该函数会被应用到每一个元素上，并将其映射成一个新的元素
        /**
         * 2----->4
         * 3----->9
         * 4----->16
         * aa----->AA
         * bb----->BB
         */
        //提取信息(提取3个姓名), 映射成新的元素  Stream<Student> --------> Stream<String>
        Stream<Student> stream = list.stream();
        Stream<String> limit = stream.map(Student::getName).limit(3);
        limit.forEach(System.out::println);
        //转换成其他形式(姓名 : 年龄), 映射成新的元素  Stream<Student> --------> Stream<String>
        Stream<Student> stream1 = list.stream();
        Stream<String> limit1 = stream1.map(student -> student.getName() + " : " + student.getAge()).limit(3);
        limit1.forEach(System.out::println);


        System.out.println("----------------------");

        //flatMap(Function f) 接收一个函数作为参数，该函数把六种的每个值都转换成一个新的流，最后再把这些流连接成一个流
        /**
         * aa,      bb,     cc,     dd      stream    Stream<String>
         *              | |
         * a,a      b,b     c,c     d,d     map()      Stream<Stream<Character>> 每个元素都产生一个流，把这些新产生的流放到一个大的流中
         *              | |
         *          a,a,b,b,c,c,d,d         flatMap()  Stream<String>    每个元素都产生了一个流，把这些新产生的流连接成一个同类型的流
         */
        Stream<Stream<String>> mapLimit = list.stream().map(Part02StreamMethod::myTest).limit(6);
        mapLimit.forEach(s->{
            s.forEach(System.out::println);
        });
        System.out.println();
        Stream<String> flatMapLimit = list.stream().flatMap(Part02StreamMethod::myTest).limit(6);
        flatMapLimit.forEach(System.out::println);
    }

    /**
     * 把每一个学生对象的姓名和工资转成 一个stream
     * @param student
     * @return
     */
    public static Stream<String> myTest(Student student){
        List<String> list = new ArrayList<>();
        list.add(student.getName());
        list.add(String.valueOf(student.getSalary()));
        return list.stream();
    }

    /******3、排序******/
    @Test
    public void test3(){
        //sorted() 自然排序
        IntStream sorted = Arrays.stream(new int[]{1, 20, 3, 5, 4, 99, 22, 11}).sorted();
        sorted.forEach(System.out::println);
        System.out.println();
        //sorted(Comparator)
        List<Student> list = StudentData.getList();
        list.stream().sorted((s1,s2)->Integer.compare(s1.getAge(),s2.getAge())).limit(3).forEach(System.out::println);
        System.out.println();
        list.stream().sorted(Comparator.comparingInt(Student::getAge)).limit(3).forEach(System.out::println);
    }
}
