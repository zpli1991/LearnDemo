package org.zpli.java8;


import java.util.*;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/18 15:28
 */
public class Reviewer {
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        // for (int i = 0; i < 500000; i++) {
        //     list.add("a" + i);
        // }
        //
        // long t1 = System.currentTimeMillis();
        // for (int i = 0; i < list.size(); i++) {
        //     // System.out.println(list.get(i));
        // }
        // long t2 = System.currentTimeMillis();
        // System.out.println(t2 - t1);
        //
        // long t3 = System.currentTimeMillis();
        // list.stream().forEach(x -> {
        //     // System.out.println(x);
        // });
        // long t4 = System.currentTimeMillis();
        // System.out.println(t4 - t3);
        //
        // long t5 = System.currentTimeMillis();
        // for (String str :
        //         list) {
        //     // System.out.println(str);
        // }
        // long t6 = System.currentTimeMillis();
        // System.out.println(t6 - t5);
        //
        // long t7 = System.currentTimeMillis();
        // Iterator<String> it = list.iterator();
        // while (it.hasNext()) {
        //    String key=  it.next();
        //     // System.out.println(key);
        // }
        // long t8 = System.currentTimeMillis();
        // System.out.println(t8 - t7);

        Object[] objects = new Object[15];
        objects[0]=10;
        objects[1]="str";
        for (int i = 0; i < objects.length; i++) {
            System.out.println("Hello"+i);
            System.out.println(objects[i]);
        }
    }

}
