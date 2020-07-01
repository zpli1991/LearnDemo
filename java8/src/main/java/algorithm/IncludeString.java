package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 假设这有一个各种字母组成的字符串A，和另外一个字符串B，字符串里B的字母数相对少一些。
 * 什么方法能最快的查出所有小字符串B里的字母在大字符串A里都有？
 * 比如，如果是下面两个字符串：String 1: ABCDEFGHLMNOPQRSString 2: DCGSRQPO答案是true，所有在string2里的字母string1也都有。
 * 如果是下面两个字符串：  String 1: ABCDEFGHLMNOPQRS   String 2: DCGSRQPZ  答案是false，因为第二个字符串里的Z字母不在第一个字符串里。
 * 点评：    1、题目描述虽长，但题意简单明了，就是给定一长一短的俩个字符串A，B，假设A长B短，现在，要你判断B是否包含在字符串A中，即B?(-A。
 * 2、题意虽简单，但实现起来并不轻松，且当如果面试官步步紧逼，一个一个否决你能想到的方法，要你给出更好、最好的方案时，你恐怕就要伤不少脑筋了。
 * ————————————————
 * 版权声明：本文为CSDN博主「v_JULY_v」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/v_JULY_v/article/details/6347454
 * @author: zpli
 * @Date: 2020/6/2 17:31
 */
public class IncludeString {

    public static void main(String[] args) {
        // String longStr = "ABCDEFGHLMNOPQRS";
        // String shortStr = "DCGSRQPO";
        String longStr = "ABCDEFGHLMNOPQRS";
        String shortStr = "DCGSRQPZ";
        System.out.println(includeString(longStr, shortStr));
    }

    public static boolean includeString(String source, String digest) {
        Set<Character> set = new HashSet<>();
        for (int i = 0, len = digest.length(); i < len; i++) {
            if (!source.contains(digest.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }
}
