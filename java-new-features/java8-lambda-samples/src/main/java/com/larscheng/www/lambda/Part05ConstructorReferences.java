package com.larscheng.www.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/***
 * 构造器引用
 * 数组引用
 */
public class Part05ConstructorReferences {


    @Test
    public void test1() {
        Supplier<Student> supplier = () -> new Student();
        System.out.println("lambda表达式，使用构造函数创建对象" + supplier.get());
        System.out.println("-----------构造器引用  类 :: new-----------");
        supplier = Student::new;
        System.out.println("方法引用，构造器引用 : " + supplier.get());
    }

    @Test
    public void test2() {
        BiFunction<String, Integer, Student> biFunction = (name, age) -> new Student(name, age);
        System.out.println("lambda表达式，使用构造函数创建对象" + biFunction.apply("lars", 18));
        System.out.println("-----------构造器引用  类 :: new-----------");
        biFunction = Student::new;
        System.out.println("方法引用，构造器引用 : " + biFunction.apply("lars", 20));
    }

    @Test
    public void test3() {
        Function<Integer, String[]> function = len -> new String[len];
        System.out.println("lambda表达式 "+Arrays.toString(function.apply(5)));
        System.out.println("--------------数组引用--------------");
        function = String[]::new;
        System.out.println("数组引用 "+Arrays.toString(function.apply(3)));
    }

    static class Student {
        private String name;
        private Integer age;


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
