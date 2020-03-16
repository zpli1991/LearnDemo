package org.zpli.java8.threadapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 14:50
 */
public class Producer {

    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produceLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.produceLock();
            }
        }).start();
    }

    public void produceSync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.produceSync();
            }
        }).start();
    }
}
