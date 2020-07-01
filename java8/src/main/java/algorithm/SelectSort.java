package algorithm;

import java.util.Arrays;

/**
 * @Description: 选择排序，时间复杂度为N的平方，不稳定
 * @author: zpli
 * @Date: 2020/6/1 10:54
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 5, 7, 1, 4, 6};
        System.out.println("选择排序前:" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("选择排序后:" + Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            if (i != min_idx) {
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        }
    }
}
