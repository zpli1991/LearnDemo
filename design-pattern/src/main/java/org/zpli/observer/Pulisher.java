package org.zpli.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/24 14:04
 */
public class Pulisher implements Subject{

    private List<ObserverIface> observerIfaces;

    public Pulisher() {
        this.observerIfaces = new ArrayList<>();
    }

    public void addObserver(ObserverIface observerIface) {
        observerIfaces.add(observerIface);
    }

    public void removeObserver(ObserverIface observerIface){
        observerIfaces.remove(observerIface);
    }

    @Override
    public void publish(String data) {
        System.out.println("***** 开始发布数据 *****");
        for (ObserverIface observerIface : observerIfaces) {
            observerIface.readData(data);
        }
        System.out.println("***** 数据发布完毕 *****");
    }
}
