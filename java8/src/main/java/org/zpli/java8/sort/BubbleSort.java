package org.zpli.java8.sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * 假设有10个数，第一轮循环，第一个数和第二个数比较，如果第一个数大，第一个数和第二个数交换位置，否则不动；接着第二个数和第三个数比较，如果第二个数大，第二个数和第三个数交换位置，否则不动……第九个数和第十个数比较，如果第九个数大，第九个数和第十个数交换位置，否则不动。第一轮循环结束，最大的数挪到了第十个数的位置，比较进行了9次。
 * 第二轮循环，第一个数和第二个数比较，如果第一个数大，第一个数和第二个数交换位置，否则不动……第八个数和第九个数比较，如果第八个数大，第八个数和第九个数交换位置，否则不动。第二轮循环结束，第二大的数挪到了第九个数的位置，比较进行了8次。
 * ……
 * 第九轮循环，第一个数和第二个数比较，如果第一个数大，第一个数和第二个数交换位置，否则不动。第九轮循环结束，倒数第二大的数挪到了第二个数的位置，比较进行了1次。
 * 总体原理：每轮比较找到最大的数。
 * @author: zpli
 * @Date: 2020/5/21 9:08
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 9, 5, 6, 1, 7, 0};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            boolean isSort = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort) return;
        }
    }

}
