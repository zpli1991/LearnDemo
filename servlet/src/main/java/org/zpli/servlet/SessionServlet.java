package org.zpli.servlet;

import com.sun.javafx.binding.StringFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 15:03
 */
public class SessionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = req.getSession();
        String sessionId = session.getId();
        //将数据存储到session中
        session.setAttribute("data", "烽火戲諸侯");
        if (session.isNew()) {
            resp.getWriter().println(String.format("session 创建成功，sessionId 是 ： %s", sessionId));
        } else {
            resp.getWriter().println(String.format("服务器已经存在该 session 了，sessionId 是 ： %s", sessionId));
        }
        System.out.println("session 数据是:"+session.getAttribute("data"));
    }
}
