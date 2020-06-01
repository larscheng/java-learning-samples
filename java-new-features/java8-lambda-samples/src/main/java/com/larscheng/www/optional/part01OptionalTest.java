package com.larscheng.www.optional;

import com.larscheng.www.stream.Student;
import com.larscheng.www.stream.StudentData;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional类，是一个容器，可保存T类型的值
 * 可以是一个为null的容器对象，如果值存在，则isPresent()方法返回true
 */
public class part01OptionalTest {
    /*
    创建
    Optional.of(T t)   创建一个Optional实例，t不能为空
    Optional.empty      创建一个空的Optional实例
    Optional.ofNullable(T t) 创建一个Optional实例，t可以为空
     */
    @Test
    public void createOptional(){
        Student s = new Student();
        //直接报错
        //Optional<Object> o = Optional.of(null);
        Optional<Student> student = Optional.of(s);
        Integer age = student.get().getAge();
        System.out.println(age);

        Optional<Object> o = Optional.ofNullable(null);
        Student student1 = Optional.ofNullable(s).orElse(new Student("张三"));
        System.out.println(student1);
    }

    /*
    判断
    boolean isPresent()  判断是否存在对象
    void ifPresent(Consumer c) 如果有值，该值就作为参数去执行Consumer，
     */
    @Test
    public void PresentTest(){

    }


    /*
    获取容器对象
    T get() 如果调用对象包含值，就返回，否则抛出异常
    T orElse(T t) 如果有值将其返回，否则返回传入的t
    T orElseGet(Supplier s) 如果有值将其返回，否则返回s执行的结果
    T orElseThrow(Supplier s) 如果优质返回，否则抛出s中的异常
     */
}
