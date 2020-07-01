package org.zpli.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/27 16:03
 */
public class MainCls {

    public static void main(String[] args) {
        ISubject realSubject = new RealSubject();
        // ISubject proxySubject = new ProxySubject(realSubject);
        // proxySubject.sayHello();


        ISubject proxyInstance = (ISubject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), new ProxyInvocationHandler(realSubject));
        proxyInstance.sayHello();
    }
}
