package com.larscheng.www.lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/***
 * https://www.bilibili.com/video/BV184411x7XA?p=7
 * JDK内置四大基础函数式接口
 * {@link Consumer#accept(Object)}    void accept(T t);    消费型接口，接受一个参数，无返回
 * {@link Supplier#get()}             T get();             供给型接口，无参数，但有返回值
 * {@link Function#apply(Object)}     R apply(T t);        函数型接口，接收参数T,返回一个R
 * {@link Predicate#test(Object)}     boolean test(T t);   断定型接口，接收参数T，判断其是否满足某一约束，返回一个boolean值
 */
public class Part01JdkBaseFunctionInterface {

    @Test
    public void test1() {
        testConsumer("Consumer<T>接收一个参数，无返回值->lambda表达式", s -> System.out.println(s));
        testConsumer("Consumer<T>接收一个参数，无返回值->表达式方法引用", System.out::println);

        System.out.println(testSupplier(() -> "Supplier<T>不接收任何参数，返回一个T类型,此处返回String"));

        System.out.println(testFunction(500, (i) -> "Function<T,R>接收一个T类型参数返回一个R类型的值，此处接收：" + i));

        System.out.println("Predicate<T>接受一个T类型参数，返回一个boolean类型值："+testPredicate(500, (integer -> integer.equals(200))));
    }


    public void testConsumer(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    public String testSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    public String testFunction(Integer i, Function<Integer, String> function) {
        return function.apply(i);
    }

    public boolean testPredicate(Integer i, Predicate<Integer> predicate) {
        return predicate.test(i);
    }


}
