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

class Student{
    private Integer id;
    private String name;
    private Integer age;
    private float salary;

    public Student(Integer id, String name, Integer age, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public float getSalary() {
        return salary;
    }

    public Student setSalary(float salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(student.salary, salary) == 0 &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}