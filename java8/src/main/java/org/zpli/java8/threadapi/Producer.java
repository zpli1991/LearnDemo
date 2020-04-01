package org.zpli.java8.threadapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 14:50
 */
public class Producer implements Runnable {

    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }


    @Override
    public void run() {
        while (true)
            depot.produceSync();
    }
}
