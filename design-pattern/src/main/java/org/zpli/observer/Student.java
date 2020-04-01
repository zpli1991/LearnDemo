package org.zpli.observer;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/24 14:08
 */
public class Student implements ObserverIface {
    @Override
    public void readData(String data) {
        System.out.println("学生接收到的数据是：" + data);
    }
}
