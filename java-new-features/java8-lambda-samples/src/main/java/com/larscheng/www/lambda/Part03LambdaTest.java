package com.larscheng.www.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Part03LambdaTest {
    /***
     *
     * 函数式接口：接口中只有一个抽象方法的接口
     * 这种接口都可以用lambda表达式来实现
     *
     * lambda 分为6种类
     *  () -> {}
     * 1-> 无参无返回值  eg:Runnable
     * 2-> 存在参数，无返回值  eg:Consumer ，1个参数时可以省略小括号
     * 3-> 存在参数，有返回值 eg:Comparator<xxx>
     *
     *
     */


    @Test
    public void test0() {
        class myThread implements Runnable {

            @Override
            public void run() {
                System.out.println("hello world!");
            }
        }
        new Thread(new myThread()).start();
    }

    @Test
    public void test00() {
        new Thread(() -> System.out.println("hello world!")).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        }).start();
    }


    @Test
    public void test000() {
        new Thread(() -> System.out.println("hello world!")).start();
    }

    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("无参无返回值的函数式接口");
            }
        };
        runnable.run();

        System.out.println("----------------------");

        runnable = () -> System.out.println("无参无返回值的lambda表达式");
        runnable.run();
    }

    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("1个参无返回值的函数式接口");

        System.out.println("----------------------");
        /*根据Consumer<String> 可进行类型推断，s的类型可省略*/
        consumer = s -> System.out.println(s);
        consumer.accept("1个参无返回值的lambda表达式");

        consumer = (System.out::println);
        consumer.accept("1个参无返回值的lambda表达式 ---> 方法引用 :: ");
    }

    @Test
    public void test22() {
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(100);
            }
        };
        System.out.println("supplier接口原始写法获取随机数：" + supplier1.get());
        System.out.println("----------------------");
        Supplier<Integer> supplier2 = () -> new Random().nextInt(100);
        System.out.println("supplier接口Lambda表达式写法获取随机数：" + supplier2.get());
    }

    @Test
    public void test222() {
        Function<Integer, String> function1 = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "接收整型参数：" + integer;
            }
        };
        System.out.println(function1.apply(100));
        System.out.println("----------------------");
        Function<Integer, String> function2 = i -> "接收整型参数：" + i;
        System.out.println(function2.apply(1000));
    }

    @Test
    public void test2222() {
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 100;
            }
        };
        System.out.println("大于100 ? " + predicate1.test(101));

        System.out.println("----------------------");

        Predicate<Integer> predicate2 = integer -> integer>100;
        System.out.println("大于100 ? " + predicate2.test(99));
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1 + " " + o2);
                return Integer.compare(o1, o2);
            }
        };
        int compare = comparator.compare(10, 20);
        System.out.println("多参数，有返回值的函数式接口：" + compare);

        System.out.println("------------------");
        comparator = ((o1, o2) -> {
            System.out.println(o1 + " " + o2);
            return o1.compareTo(o2);
        });
        System.out.println("多参数，有返回值的lambda表达式：" + comparator.compare(20, 30));

    }
}
