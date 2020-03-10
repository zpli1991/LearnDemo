package org.zpli.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
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

        System.out.println("------------ httpServletRequest ------------>");
        System.out.println(httpServletRequest.toString());
        System.out.println("------------ httpServletResponse ------------>");
        System.out.println(httpServletResponse.toString());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("------------ Filter destroy ------------");
    }
}
