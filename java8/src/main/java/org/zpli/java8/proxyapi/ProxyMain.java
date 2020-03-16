package org.zpli.java8.proxyapi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 14:48
 */
public class ProxyMain {
    public static void main(String[] args) {
        Movie proxyMovie = new RealMovie();

        Movie cinema = new Cinema(proxyMovie);
        cinema.play();

        MovieX movieX = new MovieX(proxyMovie);

        Movie movie = (Movie) Proxy.newProxyInstance(proxyMovie.getClass().getClassLoader(),
                RealMovie.class.getInterfaces(), movieX);
        movie.play();
        movie.run();
    }
}
