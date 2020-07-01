package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author: zpli
 * @Date: 2020/5/29 15:08
 */
public class Offer_48_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(a));
        System.out.println("------------");
        String b = "bbbbb";
        System.out.println(lengthOfLongestSubstring1(b));
        System.out.println("------------");
        String c = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(c));
        System.out.println("================");
        String d = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(d));
        System.out.println("------------");
        String e = "bbbbb";
        System.out.println(lengthOfLongestSubstring(e));
        System.out.println("------------");
        String f = "pwwkew";
        System.out.println(lengthOfLongestSubstring(f));
    }

    public static int lengthOfLongestSubstring1(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0, len = s.length(); j < len; j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i), flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }
}
