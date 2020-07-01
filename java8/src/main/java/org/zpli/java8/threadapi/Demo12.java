package org.zpli.java8.threadapi;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/5/15 17:16
 */
public class Demo12 {


    private static AtomicInteger money = new AtomicInteger();

    private static void increaseMoney(int n) {
       money.addAndGet(n);
    }

    public static void main(String[] args) throws InterruptedException {
        // ReentrantLock
        List<String> list = new LinkedList();
        list.get(0);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increaseMoney(1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increaseMoney(2);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("当前经济：" + money);
    }
}
