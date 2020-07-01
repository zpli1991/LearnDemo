package org.zpli.java8.threadapi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/5/15 17:16
 */
public class Demo11 {

    private static Lock lock = new ReentrantLock();

    private static int money;

    private static void increaseMoney(int n) {
        try {
            lock.lock();
            money += n;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
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
