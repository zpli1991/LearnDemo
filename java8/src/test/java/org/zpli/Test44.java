package org.zpli;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/5/27 15:32
 */
public class Test44 {

    @Test
    public void test1() {
        int max = 0;
        String str = "abcabcaa";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0, len = str.length(); j < len; j++) {
            while (sb.charAt(str.charAt(j)) > -1) {
                sb.deleteCharAt(i);
                i++;
            }
            sb.append(str.charAt(j));
            max = Math.max(max, sb.length());
        }
        System.out.println(max);
    }

    @Test
    public void test2() {
        int max = 0;
        String str = "fcafghabcdeaa";
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0, len = str.length(); j < len; j++) {
            while (set.contains(str.charAt(j))) {
                set.forEach(e-> System.out.print(e));
                System.out.println("-----------"+j);
                System.out.println(str.charAt(i));
                set.remove(str.charAt(i));
                i++;
            }
            set.add(str.charAt(j));
            // set.forEach(e-> System.out.println(e));
            // System.out.println("=============================");
            max = Math.max(max, set.size());
        }
        System.out.println(max);
    }
}
