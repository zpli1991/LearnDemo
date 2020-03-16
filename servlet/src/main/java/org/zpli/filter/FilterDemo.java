package org.zpli.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:filter的三种典型应用：
 *                     1、可以在filter中根据条件决定是否调用chain.doFilter(request, response)方法，
 *                        即是否让目标资源执行
 *                     2、在让目标资源执行之前，可以对request\response作预处理，再让目标资源执行
 *                     3、在目标资源执行之后，可以捕获目标资源的执行结果，从而实现一些特殊的功能
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/9 17:14
 */
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------------ Filter init ------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        response.setContentType("text/html;charset=utf-8");

        System.out.println("============= 此处在 doFilter 之前执行 =============");
        chain.doFilter(request,response);
        System.out.println("============= 此处在 doFilter 之后执行 =============");
    }

    @Override
    public void destroy() {
        System.out.println("------------ Filter destroy ------------");
    }
}
