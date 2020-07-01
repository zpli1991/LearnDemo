package org.zpli.java8.singletonapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 14:17
 */
public class SingletonMain {

    public static void main(String[] args) {
        SingletonDemo1 singletonDemo1 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo11 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo111 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo12 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo13 = SingletonDemo1.getInstance();
        System.out.println(singletonDemo11.toString());
        System.out.println(singletonDemo12.toString());
        System.out.println(singletonDemo13.toString());
    }


}
