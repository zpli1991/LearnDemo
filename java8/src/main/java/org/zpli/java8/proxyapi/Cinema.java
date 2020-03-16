package org.zpli.java8.proxyapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/11 14:35
 */
public class Cinema implements Movie {

    private Movie movie;

    public Cinema(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void play() {
        start();
        movie.play();
        end();
    }

    @Override
    public void run() {

    }

    private void start() {
        System.out.println("花木兰马上开始放映，爆米花、矿泉书出售");
    }

    private void end() {
        System.out.println("花木兰放映完毕，请大家有序撤离");
    }
}
