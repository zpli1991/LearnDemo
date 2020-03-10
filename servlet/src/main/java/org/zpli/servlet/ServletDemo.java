package org.zpli.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/9 16:52
 */
public class ServletDemo extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("------------ Servlet init Params ------------");
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("------------ Servlet init ------------");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("------------ Servlet service ------------");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("------------ Servlet destroy ------------");
        super.destroy();
    }

}
