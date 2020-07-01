package org.zpli.proxy;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/27 16:01
 */
public class ProxySubject implements ISubject {
    private ISubject iSubject;

    public ProxySubject(ISubject iSubject) {
        this.iSubject = iSubject;
    }

    @Override
    public void sayHello() {
        System.out.println("before execute method...");
        iSubject.sayHello();
        System.out.println("after execute method...");
    }
}
