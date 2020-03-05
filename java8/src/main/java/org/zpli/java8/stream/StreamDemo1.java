package org.zpli.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/4 18:03
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",28,500);
        Student student2 = new Student("lisi",25,380);
        Student student3 = new Student("wangwu",32,1456);
        Student student4 = new Student("zhaoliu",24,384);

        List<Student> students = Arrays.asList(student1,student2,student3,student4);

        students.stream().forEach(System.out::println);

        Student student = students.stream().sorted(Comparator.comparingInt(x->x.getAge())).findFirst().get();
        System.out.println(student);
        long num = students.stream().filter(x->x.getDistance()>400).count();
        System.out.println(num);
    }
}

class Student {

   private String name;
   private int age;
   private int distance;

    public Student(String name, int age, int distance) {
        this.name = name;
        this.age = age;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", distance=" + distance +
                '}';
    }
}
