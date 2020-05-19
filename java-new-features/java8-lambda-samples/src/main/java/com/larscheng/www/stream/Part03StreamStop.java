package com.larscheng.www.stream;

import org.junit.Test;

import java.sql.ClientInfoStatus;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/***
 * Stream终止操作
 * 流只能被消费一次，执行了终止操作后就不能再次使用
 * 匹配与查找  allMatch 、anyMatch、noneMatch、findFirst、findAny
 *
 */
public class Part03StreamStop {
    @Test
    public void test1(){
        List<Student> list = StudentData.getList();

        //allMatch 检查是否匹配所有元素
        boolean b = list.stream().allMatch(s -> s.getSalary() > 5000);
        System.out.println("工资是否都高于500："+b);


        //anyMatch 检查是否至少匹配一个元素
        boolean b1 = list.stream().anyMatch(s -> s.getSalary() > 30000);
        System.out.println("工资是否有3w以上的："+b1);

        //noneMatch 检查是否没有匹配的元素
        boolean b2 = list.stream().noneMatch(s -> s.getSalary() > 60000);
        System.out.println("工资没有6w以上的："+b2);

        //findFirst 获取并返回至包含第一个元素的流
        Optional<Student> first = list.stream().findFirst();
        System.out.println("第一个元素："+first.get());

        //findAny 返回流中任意元素
        Optional<Student> any = list.parallelStream().findAny();
        System.out.println("随机一个元素："+any.get());

    }


    @Test
    public void test2(){
        List<Student> list = StudentData.getList();
        //count 统计个数
        long count = list.stream().filter(s -> s.getAge() > 20).count();
        System.out.println("年龄大于20个人数："+count);

        //max 根据比较器返回流中最大元素
        Optional<Student> max = list.stream().max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println("年龄最大的对象："+max);
        //min 根据比较器返回流中最大元素
        Optional<Student> min = list.stream().max(Comparator.comparingDouble(Student::getSalary));
        System.out.println("工资最高的对象："+min);

        //forEach 内部迭代
        list.stream().limit(3).forEach(System.out::println);
    }
    @Test
    public void test3(){
        //reduce(T t,BinaryOperator b) 规约
    }

}
