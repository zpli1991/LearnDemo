package org.zpli.proxy;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/27 16:00
 */
public class RealSubject implements ISubject {
    @Override
    public void sayHello() {
        System.out.println("Real Subject...");
    }
}
