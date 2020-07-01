package org.zpli.java8.singletonapi;

import javax.annotation.PostConstruct;

/**
 * @Description: 枚举单例
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/1 16:08
 */
public enum SingleEnumDemo {

    INSTANCE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + getName());
    }

    public static void main(String[] args) {
        SingleEnumDemo instance = SingleEnumDemo.INSTANCE;
        instance.setName("zpli");
        instance.sayHello();
    }
}
