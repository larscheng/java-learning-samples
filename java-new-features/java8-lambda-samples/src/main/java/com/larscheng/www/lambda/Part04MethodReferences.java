package com.larscheng.www.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * 方法引用
 * 当要传递给Lambda体的操作，已经有实现方法了，就可以使用方法引用
 * 方法引用就是在使用lambda表达式，方法引用就是lambda表达的是一种语法糖
 * <p>
 * 要求： lambda表达式的参数列表和返回值类型，与某个方法的参数列表返回值一致时，此时这个方法就可以使用方法引用来调用
 * 格式：
 * 对象 :: 实例方法名
 * 类   :: 静态方法名
 * 类   :: 实例方法名
 */
public class Part04MethodReferences {
    @Test
    public void test1() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda表达式，void accept(String s)");
        System.out.println("---------------对象::实例方法名-----------");
        //获取对象
        /*PrintStream out = System.out;
        consumer = out::println;*/
        consumer = System.out::println;
        consumer.accept("方法引用, void println(String s)");
    }

    @Test
    public void test2() {
        Student student = new Student("larscheng", 18);
        Supplier<String> supplier = () -> student.getName();
        System.out.println("lambda表达式，String get() : " + supplier.get());
        System.out.println("---------------对象::实例方法名-----------");
        supplier = student::getName;
        System.out.println("方法引用，String getName() : " + supplier.get());

    }

    @Test
    public void test3() {
        Student student = new Student("larscheng", 18);
        Function<Student,String> function = s -> Student.staticMethod(s);
        System.out.println("Lambda表达式，String apply(Student s) : "+function.apply(student));
        System.out.println("---------------类::静态方法名-----------");
        function = Student::staticMethod;
        System.out.println("方法引用，static String staticMethod(Student s) : " + function.apply(student));
    }

    @Test
    public void test4() {
        Comparator<Integer> comparator = (i1,i2)->Integer.compare(i1,i2);
        System.out.println("Lambda表达式，int compare(Integer i1, Integer i2) : "+comparator.compare(10, 11));
        System.out.println("---------------类::静态方法名-----------");
        comparator = Integer::compare;
        System.out.println("方法引用，static int compare(int i1, int i2) : "+comparator.compare(10, 11));
        System.out.println("---------------类::实例方法名 method(a,b) => a.method(b)-----------");
        comparator = Integer::compareTo;
        System.out.println("方法引用，i1.compareTo(i2) return int : "+comparator.compare(10, 11));

        /**
         * 很多这种例子，String => s1.equals(s2)
         */
    }
    @Test
    public void test5() {
        Student student = new Student("larscheng", 18);
        Function<Student,String> function = s -> s.getName();
        System.out.println("Lambda表达式，String apply(Student s) : "+function.apply(student));
        System.out.println("---------------类::实例方法名 R method(T t) => t.method() return R-----------");
        function = Student::getName;
        System.out.println("方法引用，student.getName() return String  : "+function.apply(student));
    }
    static class Student {
        private String name;
        private Integer age;


        /***
         * 手动实现的一个静态方法
         */
        public static String staticMethod(Student student) {
            return student.toString();
        }

        public Student() {
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
