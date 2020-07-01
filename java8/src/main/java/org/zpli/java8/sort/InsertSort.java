package org.zpli.java8.sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @author: zpli
 * @Date: 2020/5/27 9:26
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 9, 5, 6, 1, 7, 0};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
    }

    private static void insertSort(int[] arr) {
        for (int i = 1, len = arr.length; i < len; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
