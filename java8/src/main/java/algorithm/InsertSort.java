package algorithm;

import java.util.Arrays;

/**
 * @Description: 插入排序，时间复杂度为N的平方
 * @author: zpli
 * @Date: 2020/6/1 10:54
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 5, 7, 1, 4, 6};
        System.out.println("插入排序前:" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("插入排序后:" + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1, len = arr.length; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
