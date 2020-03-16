package org.zpli.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 17:05
 */
public class ReflectionDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        Class stClass1 = student.getClass();

        Class clazz = Student.class;

        System.out.println(stClass1 == clazz);

        Class stClass3 = Class.forName("org.zpli.java8.reflection.Student");
        System.out.println(clazz == stClass3);

        System.out.println(stClass1.equals(clazz));
        System.out.println(stClass3.equals(clazz));

        // Constructor[] constructors = clazz.getDeclaredConstructors();
        // for (int i = 0; i < constructors.length; ++i) {
        //     Constructor constructor = constructors[i];
        //     System.out.print(Modifier.toString(constructor.getModifiers()) + " 参数: ");
        //     Class[] parameterTypes = constructor.getParameterTypes();
        //     for (int j = 0; j < parameterTypes.length; ++j) {
        //         System.out.print(parameterTypes[j].getName());
        //     }
        //     System.out.println("");
        // }
    }
}

