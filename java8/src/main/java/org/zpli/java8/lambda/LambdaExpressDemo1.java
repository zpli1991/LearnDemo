package org.zpli.java8.lambda;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 函数式编程
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/19 17:57
 */
public class LambdaExpressDemo1 {

    public static void main(String[] args) {
        Foo foo = (x) -> System.out.println("Hello World " + x);
        foo.hello("zpli");

    }
}

interface Foo {
    void hello(String name);
}
