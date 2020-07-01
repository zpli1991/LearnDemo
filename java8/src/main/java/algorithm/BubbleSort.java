package algorithm;

import java.util.Arrays;

/**
 * @Description: 冒泡排序，时间复杂度为N的平方
 * @author: zpli
 * @Date: 2020/6/1 10:44
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 5, 7, 1, 4, 6};
        System.out.println("冒泡排序前:"+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序后:"+ Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // int temp = arr[j+1];
                    // arr[j+1] = arr[j];
                    // arr[j] = temp;
                    swap = true;
                }
            }
            if (!swap) return;
        }
    }

}
