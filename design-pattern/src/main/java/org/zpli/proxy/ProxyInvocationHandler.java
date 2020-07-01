package org.zpli.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/27 16:39
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private ISubject realSubject;

    public ProxyInvocationHandler(ISubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- before -----");
        method.invoke(realSubject,args);
        System.out.println("----- after -----");
        return null;
    }
}
