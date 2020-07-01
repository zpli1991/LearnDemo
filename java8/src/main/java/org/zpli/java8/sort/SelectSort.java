package org.zpli.java8.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * 假设有10个数，第一轮循环，第一个数和第二个数比较，如果第一个数大，第一个数和第二个数交换位置，否则不动；接着第一个数和第三个数比较，如果第一个数大，第一个数和第三个数交换位置，否则不动……第一个数和第十个数比较，如果第一个数大，第一个数和第十个数交换位置，否则不动。第一轮循环结束，最小的数挪到了第一个数的位置，比较进行了9次。
 * 第二轮循环，第二个数和第三个数比较，如果第二个数大，第而个数和第三个数交换位置，否则不动……第二个数和第十个数比较，如果第二个数大，第二个数和第十个数交换位置，否则不动。第二轮循环结束，第二小的数挪到了第二个数的位置，比较进行了8次。
 * ……
 * 第九轮循环，第九个数和第十个数比较，如果第九个数大，第九个数和第十个数交换位置，否则不动。第九轮循环结束，倒数第二小的数挪到了倒数第二个的位置，比较进行了1次。
 * @author: zpli
 * @Date: 2020/5/21 15:49
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 9, 5, 6, 1, 7, 0};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minPosition] > arr[j]) {
                    minPosition = j;
                }
            }
            int temp = arr[minPosition];
            arr[minPosition] = arr[i];
            arr[i] = temp;
        }
    }
}
