package org.zpli.java8.threadapi;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/7/8 8:58
 */
public class BlockingQueueDemo<E> {

    public static void main(String[] args) {
        BlockingQueueDemo<String> blockingQueueDemo = new BlockingQueueDemo(10);
        new Thread(() -> {
            while (true) {
                try {
                    // String element = blockingQueueDemo.getElement();
                    String e = blockingQueueDemo.poll();
                    // System.out.println(element);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    // blockingQueueDemo.addElement(UUID.randomUUID().toString());
                    blockingQueueDemo.push(UUID.randomUUID().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private LinkedList<E> items = new LinkedList<>();
    private int maxCount;
    private Lock lock = new ReentrantLock();
    Condition fullCondion = lock.newCondition();
    Condition emptyCondion = lock.newCondition();

    public BlockingQueueDemo(int maxCount) {
        this.maxCount = maxCount;
    }

    public E poll() {
        lock.lock();
        E ele = null;
        try {
            while (items.size() <= 0) {
                emptyCondion.await();
            }
            ele = items.remove(0);
            System.out.println("pop -> " + items.size());
            fullCondion.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return ele;
    }

    public void push(E ele) {
        lock.lock();
        try {
            while (items.size() >= maxCount) {
                fullCondion.await();
            }
            items.add(ele);
            System.out.println("push -> " + items.size());
            emptyCondion.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public E getElement() throws InterruptedException {
        while (items.size() <= 0) {
            wait();
        }
        E e = items.remove(0);
        System.out.println("getElement -> " + items.size());
        notifyAll();
        return e;
    }

    public void addElement(E element) throws InterruptedException {
        while (items.size() >= maxCount) {
            wait();
        }
        items.add(element);
        System.out.println("addElement -> " + items.size());
        notifyAll();
    }
}
