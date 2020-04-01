package org.zpli.java8.threadapi;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/24 14:47
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(()->{
            try {
                semaphore.acquire(3);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("线程"+ Thread.currentThread().getName()+"申请3个信号量开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("线程"+ Thread.currentThread().getName()+"执行完毕");
            }
        });
        executorService.execute(()->{
            try {
                semaphore.acquire(5);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("线程"+ Thread.currentThread().getName()+"申请5个信号量开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("线程"+ Thread.currentThread().getName()+"执行完毕");
            }
        });
        executorService.execute(()->{
            try {
                semaphore.acquire(4);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("线程"+ Thread.currentThread().getName()+"申请4个信号量开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("线程"+ Thread.currentThread().getName()+"执行完毕");
            }
        });
        executorService.shutdown();
    }
}
