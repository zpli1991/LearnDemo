package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author: zpli
 * @Date: 2020/7/6 15:34
 */
public class LeetCode_128_LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] arr){
        int longestStreak = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:arr ){
            set.add(num);
        }
        for (int num:set){
            if (!set.contains(num-1)){
                int currentNum = num,currentStreak=1;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(currentStreak,longestStreak);
            }
        }
        return longestStreak;
    }
}
