package com.larscheng.www.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentData {
    public static List<Student> getList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1001,"张三",34,50000));
        list.add(new Student(1002,"李四",19,3000));
        list.add(new Student(1003,"王五",14,600));
        list.add(new Student(1004,"赵六",42,30000));
        list.add(new Student(1005,"李明",22,6000));
        list.add(new Student(1006,"张华",32,40000));
        list.add(new Student(1007,"李华",30,9000));
        list.add(new Student(1008,"王二",28,12000));
        return list;
    }




}