package org.zpli.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/12 14:29
 */
public class ReflectionMethod {

    /**
     * 获取成员方法并调用：
     * <p>
     * 1.批量的：
     * public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
     * public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
     * 2.获取单个的：
     * public Method getMethod(String name,Class<?>... parameterTypes):
     * 参数：
     * name : 方法名；
     * Class ... : 形参的Class类型对象
     * public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
     * <p>
     * 调用方法：
     * Method --> public Object invoke(Object obj,Object... args):
     * 参数说明：
     * obj : 要调用方法的对象；
     * args:调用方式时所传递的实参；
     */

    public static void main(String[] args) throws Exception {
        // 1.加载class对象
        Class aClass = Class.forName("org.zpli.java8.reflection.Student");

        Method[] methods = aClass.getMethods();
        System.out.println("公有方法");
        Arrays.stream(methods).forEach(x-> System.out.println(x));

        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("所有方法");
        Arrays.stream(declaredMethods).forEach(System.out :: println);

        System.out.println("获取公有方法并调用");
        Object o = aClass.newInstance();
        Method show1 = aClass.getMethod("show1", String.class);
        show1.invoke(o,"zpli");
        System.out.println("获取私有方法并调用");
        Constructor constructor = aClass.getConstructor();
        Object o1 = constructor.newInstance();
        Method show4 = aClass.getDeclaredMethod("show4", int.class, String.class);
        show4.setAccessible(true);
        Object lizp = show4.invoke(o1, 28, "lizp");
        System.out.println(lizp);
    }
}
