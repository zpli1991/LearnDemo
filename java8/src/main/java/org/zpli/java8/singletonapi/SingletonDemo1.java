package org.zpli.java8.singletonapi;

/**
 * @Description: 懒汉式单例模式
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 14:14
 */
public class SingletonDemo1 {

    private static final SingletonDemo1 singletonDemo1 = new SingletonDemo1();

    private SingletonDemo1() {

    }

    public static SingletonDemo1 getInstance(){
        return singletonDemo1;
    }
}
