package algorithm;

import java.util.Stack;

/**
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @author: zpli
 * @Date: 2020/7/6 14:13
 */
public class LeetCode_5_LongestPalindrome {
    public static void main(String[] args) {
        // System.out.println(longestPalindrome("babad"));
        // System.out.println(longestPalindrome("aba"));
        // System.out.println(longestPalindrome("cbbd"));
        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        // System.out.println(isPalindrome(" e a "));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); ;
    }

    public static int maxProfit(int[] prices) {
        int maxMoney = 0;
        for(int i=0,len=prices.length;i<len;i++){
            for(int j=i+1;j<len;j++){
                maxMoney = Math.max(maxMoney,prices[j]-prices[i]);
            }
        }
        return maxMoney;
    }

    // 1、如果传入重合的索引编码，进行中心扩散，此时得到的回文子串的长度是奇数；
    //         2、如果传入相邻的索引编码，进行中心扩散，此时得到的回文子串的长度是偶数。
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0, len = s.length(); i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }


    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
