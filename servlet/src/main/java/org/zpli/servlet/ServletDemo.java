package org.zpli.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/9 16:52
 */
public class ServletDemo extends HttpServlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("------------ Servlet init Params ------------");
        this.servletConfig = config;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("------------ Servlet init ------------");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------ Servlet service ------------");
        PrintWriter out = resp.getWriter();
        StringBuilder sb = new StringBuilder("Hello Service Info -->\n");
        sb.append("<br />");
        sb.append("<hr />");
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = servletConfig.getInitParameter(name);
            sb.append(String.format("%s : %s", name, value));
            sb.append("<br />");
        }
        out.println(sb);
    }

    @Override
    public void destroy() {
        System.out.println("------------ Servlet destroy ------------");
        super.destroy();
    }

}
