package org.zpli.java8.proxyapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 14:34
 */
public class RealMovie implements Movie {

    @Override
    public void run() {
        System.out.println("跑起来吧");
    }

    @Override
    public void play() {
        System.out.println("我将要放映刘亦菲主演的花木兰");
    }

    public void sayHello(){
        System.out.println("我会说Hello");
    }
}
