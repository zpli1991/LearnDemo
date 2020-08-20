package algorithm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 三个线程循环打印ABC
 * @author: zpli
 * @Date: 2020/6/15 14:59
 */
public class PrintABC {
    private static volatile int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        printABC1();
        // printABC2();
    }

    private static void printABC1() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (flag == 0) {
                    System.out.println("A");
                    flag = 1;
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            while (true) {
                if (flag == 1) {
                    System.out.println("B");
                    flag = 2;
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            while (true) {
                if (flag == 2) {
                    System.out.println("C");
                    flag = 0;
                }
            }
        }).start();
    }

    private static void printABC2(){
        ABCDemo abcDemo = new ABCDemo();
        new Thread(()-> {
            try {
                abcDemo.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                abcDemo.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                abcDemo.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    static class ABCDemo {

        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        volatile int flag = 0;

        private void printA() throws InterruptedException {
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
            } finally {
                lock.unlock();
            }
        }

        private void printB() throws InterruptedException {
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
            } finally {
                lock.unlock();
            }
        }

        private void printC() throws InterruptedException {
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
            } finally {
                lock.unlock();
            }
        }
    }
}
