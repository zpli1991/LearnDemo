package org.zpli.java8.threadapi;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/6 9:48
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("Hello World");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "HelloWorld");
        executorService.shutdown();
        System.out.println("future is Done ? " + future.isDone());
        System.out.println(future.get());
        System.out.println("future is Done ? " + future.isDone());

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("name", "zpli");
        concurrentHashMap.put("age", 28);
        System.out.println(concurrentHashMap.get("name"));
        System.out.println(concurrentHashMap.get("age"));
        concurrentHashMap.putIfAbsent("name", "liutao");
        concurrentHashMap.putIfAbsent("sex", "male");
        System.out.println(concurrentHashMap.get("name"));
        System.out.println(concurrentHashMap.get("sex"));
    }
}
