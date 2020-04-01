package org.zpli.java8.threadapi;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/23 14:10
 */
public class CopyOnWriteArraySetDemo {
    // CopyOnWriteArraySetDemo是线程安全的集合，通过动态数组CopyOnWriteArrayList实现
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        ConcurrentHashMap map = new ConcurrentHashMap();
         LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();

        // 栈 stack  FILO 先进后出
        // 队列 queue FIFO 先进先出

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        new Thread(()-> {
            try {
                while (true)
                queue.offer("a");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                while (true) {
                    String take = queue.take();
                    System.out.println(take);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
