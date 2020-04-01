package org.zpli.java8.singletonapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 14:19
 */
public class SingletonDemo2 {

    private static volatile SingletonDemo2 singletonDemo2 = null;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance() {
        if (null == singletonDemo2) {
            synchronized (SingletonDemo2.class) {
                if (null == singletonDemo2) {
                    singletonDemo2 = new SingletonDemo2();
                }
            }
        }
        return singletonDemo2;
    }
}
