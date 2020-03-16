package org.zpli.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/10 13:53
 */
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        StringBuilder sb = new StringBuilder();
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            Arrays.asList(cookies).stream().forEach(x -> {
                String name = x.getName();
                String value = x.getValue();
                if (name.equals("lastAccessTime")) {
                    LocalDateTime localDateTime = Instant.ofEpochMilli(Long.parseLong(value)).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String lastAccessTime = dateTimeFormatter.format(localDateTime);
                    sb.append(name + " : " + lastAccessTime);
                    sb.append("<hr />");
                } else {
                    sb.append(name + " : " + value);
                    sb.append("<hr />");
                }
            });
            writer.println(sb);
        } else {
            writer.println("這是您第一次訪問");
        }

        Cookie lastAccessTime = new Cookie("lastAccessTime", LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli() + "");
        lastAccessTime.setMaxAge(24 * 60 * 60);
        Cookie lastAccessURI = new Cookie("lastAccessURI", req.getRequestURI());
        Cookie accessUser = new Cookie("accessUser","李宗萍");
        resp.addCookie(lastAccessTime);
        resp.addCookie(lastAccessURI);
        resp.addCookie(accessUser);
    }
}
