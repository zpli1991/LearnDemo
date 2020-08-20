package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * @author: zpli
 * @Date: 2020/6/30 10:24
 */
public class LeetCode_20_BracketIsValid {

    public static void main(String[] args) {
        System.out.println(isValid("[]"));
        System.out.println(9/2);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        if (s.isEmpty()) {
            return true;
        }
        // 如果第一个字符为右半部分直接返回false
        if (map.containsValue(s.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char charAt = s.charAt(i);
            // 左括号
            if (map.containsKey(charAt)) {
                stack.push(charAt);
            }
            // 右括号
            else {
                if (stack.empty()) {
                    return false;
                }
                if (map.get(stack.pop()) != charAt) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
