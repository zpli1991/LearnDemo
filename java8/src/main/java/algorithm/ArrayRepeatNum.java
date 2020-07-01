package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 找出数组中重复的数字
 * @author: zpli
 * @Date: 2020/6/10 17:29
 */
public class ArrayRepeatNum {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(arr));
    }

    public static int arrRepeatNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static int arrRepeatNum2(int[] arr) {
        // {4, 3, 1, 0, 2, 5, 3}
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return -1;
            }
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return -1;
    }

    public static int duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0)
            return -1;
        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return numbers[i];
                } else {
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return -1;
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        // {4, 3, 1, 0, 2, 5, 3}
        for (int i = 0, len = nums.length; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }
}
