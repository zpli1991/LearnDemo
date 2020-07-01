package algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/11 13:31
 */
public class ReverseStr {

    public static void main(String[] args) {
        System.out.println(reverseStr1("lizongpings"));
        System.out.println(reverseStr2("lizongping"));
    }

    private static String reverseStr1(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = str.length(); i < len; i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0, size = stack.size(); i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static String reverseStr2(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
        return Arrays.toString(chars);
    }

    public String reverseWords(String s) {
        String[] strAry = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : strAry){
            sb.append(new StringBuilder(str).reverse());
        }
        return sb.toString().trim();
    }

}
