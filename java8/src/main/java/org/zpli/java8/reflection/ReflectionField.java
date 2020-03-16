package org.zpli.java8.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/12 14:05
 */
public class ReflectionField {

    /**
     * 获取成员变量并调用：
     *
     * 1.批量的
     * 		1).Field[] getFields():获取所有的"公有字段"
     * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
     * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     *
     * 	 设置字段的值：
     * 		Field --> public void set(Object obj,Object value):
     * 					参数说明：
     * 					1.obj:要设置的字段所在的对象；
     * 					2.value:要为字段设置的值；
     *
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.加载class对象
        Class aClass = Class.forName("org.zpli.java8.reflection.Student");

        System.out.println("公有字段");
        Field[] fields = aClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("所有字段");
        Field[] declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out :: println);

        System.out.println("获取公有字段并赋值");
        Field company = aClass.getDeclaredField("name");
        company.setAccessible(true);
        System.out.println(company);
        // 获取一个对象
        Object o = aClass.getConstructor().newInstance();
        company.set(o,"李宗萍");
        Student student = (Student) o;
        System.out.println(student.getName());

    }
}
