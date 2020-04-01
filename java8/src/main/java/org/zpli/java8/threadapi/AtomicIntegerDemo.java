package org.zpli.java8.threadapi;

import org.apache.commons.io.FileUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/20 10:29
 */
public class AtomicIntegerDemo {
    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        // for (int i = 0; i < 10000; i++) {
        //     new Thread(() -> {
        //         count.incrementAndGet();
        //         System.out.println(count.get());
        //     }).start();
        //
        // }
// HashSet
        List<String> list = new CopyOnWriteArrayList<>();
        // ConcurrentHashMap;
        // ConcurrentSkipListMap
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }
}
