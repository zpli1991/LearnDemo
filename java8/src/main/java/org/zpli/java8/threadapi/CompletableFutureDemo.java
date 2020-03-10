package org.zpli.java8.threadapi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/6 10:13
 */
public class CompletableFutureDemo {

    // CompletableFuture
    // static CompletableFuture<Void> runAsync(Runnable runnable)
    //1. 返回一个新的CompletableFuture，它在运行给定操作后由运行在 ForkJoinPool.commonPool()中的任务 异步完成。

    // static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
    //2. 返回一个新的CompletableFuture，它在运行给定操作之后由在给定执行程序中运行的任务异步完成。

    // static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
    //3. 返回一个新的CompletableFuture，它通过在 ForkJoinPool.commonPool()中运行的任务与通过调用给定的供应商获得的值 异步完成。

    // static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
    //4. 返回一个新的CompletableFuture，由给定执行器中运行的任务异步完成，并通过调用给定的供应商获得的值。
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B");
        CompletableFuture<String> futureC = futureB.thenApply(b -> {
            System.out.println("执行任务C.");
            System.out.println("参数:" + b);//参数:任务B
            System.out.println("---------------------------------");
            return "a";
        });

        System.out.println(futureA.get());
        System.out.println(futureB.get());
        System.out.println(futureC.get());
    }
}
