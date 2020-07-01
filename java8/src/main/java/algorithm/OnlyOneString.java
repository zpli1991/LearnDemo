package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是”g”。
 * 当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是”l”。
 * @author: zpli
 * @Date: 2020/6/11 10:02
 */
public class OnlyOneString {

    public static void main(String[] args) {
        String str = "google";
        System.out.println(findOnlyOne(str));
    }

    public static Character findOnlyOne(String str) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                sb.append(c);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (map.get(sb.charAt(i)) == 1)
                return sb.charAt(i);
        }
        return "#".charAt(0);
    }
}
