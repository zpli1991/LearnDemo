package org.zpli.java8.threadapi;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 15:05
 */
public class DepotMain {
    public static void main(String[] args) {
        // TimeUnit.SECONDS.sleep(1);
        Depot depot = new Depot(7);
        new Thread(new Producer(depot)).start();
        new Thread(new Consumer(depot)).start();
        new Thread(new Producer(depot)).start();
        new Thread(new Consumer(depot)).start();
    }
}
