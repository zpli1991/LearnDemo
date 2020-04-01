package org.zpli.java8.threadapi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/23 13:16
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(()->{
            TimeUnit.SECONDS.sleep(3);
            return "Hello World!";
        });
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);
    }
}
