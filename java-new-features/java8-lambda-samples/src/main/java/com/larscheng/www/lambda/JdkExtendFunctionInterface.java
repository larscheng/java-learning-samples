package com.larscheng.www.lambda;

import java.util.function.*;

/***
 * https://www.bilibili.com/video/BV184411x7XA?p=7
 * JDK内置四大基础函数式接口的<blod>其他扩展接口</blod>
 * {@link Consumer}    void accept(T t);    消费型接口，接受一个参数，无返回
 *      {@link BiConsumer}          void accept(T t, U u);
 *      {@link IntConsumer}         void accept(int value);
 *      {@link DoubleConsumer}      void accept(double value);
 * {@link Supplier}    T get();             供给型接口，无参数，但有返回值
 * {@link Function}    R apply(T t);        函数型接口，接收参数T,返回一个R
 * {@link Predicate}   boolean test(T t);   断定型接口，接收参数T，判断其是否满足某一约束，返回一个boolean值
 */
public class JdkExtendFunctionInterface {
}
