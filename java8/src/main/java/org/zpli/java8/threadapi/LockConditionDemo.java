package org.zpli.java8.threadapi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 三个线程 循环打印ABC，循环十次
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/23 9:30
 */

public class LockConditionDemo {

    // synchronized wait notify/notifyAll 全部通知
    // lock condition await signal/signalAll 定点通知唤醒
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int idx = 0; idx < 10; idx++) {
            new Thread(() -> {
                shareData.printA();
            }).start();

            new Thread(() -> {
                shareData.printB();
            }).start();

            new Thread(() -> {
                shareData.printC();
            }).start();
        }

    }

}

class ShareData {

    // 标志位
    int number = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (number != 1)
                c1.await();
            number = 2;
            for (int i = 0; i < 5; i++) {
                System.out.println("A...");
            }
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2)
                c2.await();
            number = 3;
            for (int i = 0; i < 10; i++) {
                System.out.println("B...");
            }
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number != 3)
                c3.await();
            number = 1;
            for (int i = 0; i < 15; i++) {
                System.out.println("C...");
            }
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
