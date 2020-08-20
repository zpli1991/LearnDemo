package org.zpli.java8.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/7/7 16:55
 */
public class PrintABC {


    public static void main(String[] args) throws InterruptedException {

        ABCDemo demo = new ABCDemo();
        new Thread(() -> demo.printA()).start();
        Thread.sleep(1);
        new Thread(() -> demo.printB()).start();
        Thread.sleep(1);
        new Thread(() -> demo.printC()).start();
    }

    static class ABCDemo {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        volatile int flag = 0;

        public void printA() {
            try {
                lock.lock();
                while (true) {
                    while (flag != 0) {
                        conditionA.await();
                    }
                    System.out.println("A");
                    flag = 1;
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void printB() {
            try {
                lock.lock();
                while (true) {
                    while (flag != 1) {
                        conditionB.await();
                    }
                    System.out.println("B");
                    flag = 2;
                    conditionC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void printC() {
            try {
                lock.lock();
                while (true) {
                    while (flag != 2) {
                        conditionC.await();
                    }
                    System.out.println("C");
                    flag = 0;
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
