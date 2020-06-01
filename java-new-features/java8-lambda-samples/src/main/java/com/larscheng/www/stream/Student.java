package com.larscheng.www.stream;

import java.util.Objects;

public class Student {
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

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Integer getId() {
            return id;
        }

        public com.larscheng.www.stream.Student setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public com.larscheng.www.stream.Student setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public com.larscheng.www.stream.Student setAge(Integer age) {
            this.age = age;
            return this;
        }

        public float getSalary() {
            return salary;
        }

        public com.larscheng.www.stream.Student setSalary(float salary) {
            this.salary = salary;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.larscheng.www.stream.Student student = (com.larscheng.www.stream.Student) o;
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
