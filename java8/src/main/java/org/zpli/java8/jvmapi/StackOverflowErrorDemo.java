package org.zpli.java8.jvmapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/26 17:18
 */
public class StackOverflowErrorDemo {

    private int stackCount;

    public static void main(String[] args) {
        StackOverflowErrorDemo demo = new StackOverflowErrorDemo();
        try {
            demo.stackOverflow();
        } catch (Throwable e) {
            System.out.println("stackCount ： " + demo.stackCount);
            e.printStackTrace();
        }
    }

    private void stackOverflow() {
        stackCount++;
        stackOverflow();
    }
}
