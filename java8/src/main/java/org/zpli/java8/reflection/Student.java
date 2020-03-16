package org.zpli.java8.reflection;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/12 14:28
 */
class Student {
    private String name;
    private int age;
    private String addr;

    public String company;

    public Student() {
        System.out.println("默认的构造方法");
    }

    private Student(String name, int age) {
        System.out.println("private Student(String name, int age)");
        this.name = name;
        this.age = age;
    }

    protected Student(String name, String age) {
        System.out.println("protected Student(String name, String age)");
    }

    private Student(int age, String addr) {
        System.out.println("private Student(int age, String addr)");
    }

    public Student(String name, int age, String addr) {
        System.out.println("public Student(String name, int age, String addr)");
        this.name = name;
        this.age = age;
        this.addr = addr;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age,String name){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age+", name="+name);
        return "abcd";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
