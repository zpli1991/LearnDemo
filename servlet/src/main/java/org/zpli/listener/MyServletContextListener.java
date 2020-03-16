package org.zpli.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 16:50
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------------- MyServletContextListener 监听器启动 ---------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------------- MyServletContextListener 监听器销毁 ---------------");
    }
}
