package org.zpli.java8.callback;

/**
 * @Description: 神仙类
 * @author: zpli
 * @Date: 2020/3/19 15:35
 */
public class Immortal {

    private String name;

    public Immortal(String name){
        this.name = name;
    }

    public void crossingSea(Magic magic){
        System.out.print(name);
        magic.doMagic();
        System.out.println("过海。。。");
    }
}
