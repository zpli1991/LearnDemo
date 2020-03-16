package org.zpli.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/12 10:13
 */
public class ReflectionConstructor {

    /**
     * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
     * <p>
     * 1.获取构造方法：
     * 1).批量的方法：
     * public Constructor[] getConstructors()：所有"公有的"构造方法
     * public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
     * <p>
     * 2).获取单个的方法，并调用：
     * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     * <p>
     * 调用构造方法：
     * Constructor-->newInstance(Object... initargs)
     */

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 1.加载class对象
        Class<?> aClass = Class.forName("org.zpli.java8.reflection.Student");

        // 2.获取所有公有构造函数
        System.out.println("********* 所有公有构造函数 *********");
        Constructor<?>[] constructors = aClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out :: println);

        // 2.获取所有公有构造函数
        System.out.println("********* 所有公有构造函数(包括：私有、公有、受保护、默认) *********");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out :: println);

        System.out.println("********* 公有无参构造函数 *********");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);
        declaredConstructor.setAccessible(true);
        Student zpli = (Student) declaredConstructor.newInstance("zpli", 22);
        System.out.println(zpli);
    }

}
