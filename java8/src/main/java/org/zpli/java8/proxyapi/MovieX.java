package org.zpli.java8.proxyapi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 15:03
 */
public class MovieX<E> implements InvocationHandler {

    private E object;

    public MovieX(E object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("xxxxxxxx");
        method.invoke(object,args);
        System.out.println("yyyyyyyyyyy");
        return null;
    }
}
