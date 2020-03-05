package org.zpli.java8.stream.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/5 13:27
 */

public class Apple {

    public static void main(String[] args) {
        RedApple r1 = new RedApple("red1", 33);
        RedApple r2 = new RedApple("red2", 24);
        RedApple r3 = new RedApple("red3", 31);
        RedApple r4 = new RedApple("red4", 46);

        List<RedApple> redApples = Arrays.asList(r1, r2, r3, r4);
        Collections.sort(redApples);
        redApples.forEach(System.out::println);

        System.out.println("================= 此处应该有分割线 =================");
        YellowApple y1 = new YellowApple("yellow1", 33);
        YellowApple y2 = new YellowApple("yellow2", 43);
        YellowApple y3 = new YellowApple("yellow3", 23);
        YellowApple y4 = new YellowApple("yellow4", 63);
        List<YellowApple> yellowApples = Arrays.asList(y1, y2, y3, y4);
        yellowApples.sort((x, y) -> x.getSize() - y.getSize());
        yellowApples.forEach(x->System.out.println(x));
    }
}

class RedApple implements Comparable<RedApple> {

    private String name;
    private int size;

    public RedApple(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "RedApple{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public int compareTo(RedApple o) {
        return this.size - o.size;
    }
}

class YellowApple {

    private String name;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public YellowApple(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "YellowApple{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}