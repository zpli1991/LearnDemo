package algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 多个线程按顺序打印1~100的数字
 * @author: zpli
 * @Date: 2020/6/15 10:55
 */
public class ThreadPrintNum {

    private static volatile int flag = 0;
    private static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println("启动主线程。。。");
        new Thread(() -> {
            while (num.get() < 100) {
                if (flag == 0) {
                    System.out.println("t1:" + num.get());
                    num.incrementAndGet();
                    flag = 1;
                }
            }
        }).start();
        new Thread(() -> {
            while (num.get() < 100) {
                if (flag == 1) {
                    System.out.println("t2:" + num.get());
                    num.incrementAndGet();
                    flag = 2;
                }
            }
        }).start();
        new Thread(() -> {
            while (num.get() < 100) {
                if (flag == 2) {
                    System.out.println("t3:" + num.get());
                    num.incrementAndGet();
                    flag = 0;
                }
            }
        }).start();
        // new Thread(() -> {
        //     int i = 0;
        //     while (i < 100) {
        //         if (flag == 0) {
        //             System.out.println("线程1：" + i);
        //             i += 2;
        //             flag = 1;
        //         }
        //     }
        //
        // }).start();
        // new Thread(() -> {
        //     int i = 1;
        //     while (i < 100) {
        //         if (flag == 1) {
        //             System.out.println("线程2：" + i);
        //             i += 2;
        //             flag = 0;
        //         }
        //     }
        // }).start();
        // System.out.println("主线程执行完毕。。。");
    }

    class Controller {

    }

}
