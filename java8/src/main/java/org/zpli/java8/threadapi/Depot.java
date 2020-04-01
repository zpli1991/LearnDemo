package org.zpli.java8.threadapi;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 14:51
 */
public class Depot {

    private final int MAX_COUNT = 10;
    private final int MIN_COUNT = 3;
    private int currentCount;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public Depot(int currentCount) {

        this.currentCount = currentCount;
    }


    public void produceLock() {
        lock.lock();
        try {
            while (this.currentCount >= this.MAX_COUNT) {
                condition.await();
            }
            this.currentCount++;
            System.out.println("当前数量是：" + this.currentCount);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void produceSync() {
        try {
            while (this.currentCount >= this.MAX_COUNT) {
                wait();
            }
            this.currentCount++;
            System.out.println("当前线程是" + Thread.currentThread().getName() + "produceSync当前数量是：" + this.currentCount);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consumeLock() {
        lock.lock();
        try {
            while (this.currentCount <= this.MIN_COUNT) {
                condition.await();
            }
            this.currentCount--;
            System.out.println("当前数量是：" + this.currentCount);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void consumeSync() {
        try {
            while (this.currentCount <= this.MIN_COUNT) {
                wait();
            }
            this.currentCount--;
            System.out.println("当前线程是" + Thread.currentThread().getName() + "consumeSync当前数量是：" + this.currentCount);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
