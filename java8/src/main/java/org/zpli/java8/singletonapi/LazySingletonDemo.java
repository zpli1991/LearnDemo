package org.zpli.java8.singletonapi;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/7/1 17:59
 */
public class LazySingletonDemo {

    private static volatile LazySingletonDemo demo;

    private LazySingletonDemo() {

    }

    public static LazySingletonDemo getInstance() {
        if (demo == null) {
            synchronized (LazySingletonDemo.class) {
                if (demo == null) {
                    demo = new LazySingletonDemo();
                }
            }
        }
        return demo;
    }
}
