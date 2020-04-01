package org.zpli.observer;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/24 14:09
 */
public class Teacher implements ObserverIface {
    @Override
    public void readData(String data) {
        System.out.println("老师接收到的数据是：" + data);
    }
}
