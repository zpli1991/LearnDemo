package org.zpli.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 17:07
 */
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("--------------- MyHttpSessionListener 监听器启动 ---------------");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("--------------- MyHttpSessionListener 监听器销毁 ---------------");
    }
}
