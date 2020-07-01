package org.zpli.java8.singletonapi;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/5/14 16:33
 */
public class SingletonDemo4 {

    private static volatile SingletonDemo4 singletonDemo4 = null;

    private SingletonDemo4() {

    }

    public static SingletonDemo4 getInstance() {
        if (singletonDemo4 == null) {
            synchronized (SingletonDemo4.class) {
                if (singletonDemo4 == null) {
                    singletonDemo4 = new SingletonDemo4();
                }
            }
        }
        return singletonDemo4;
    }
}
