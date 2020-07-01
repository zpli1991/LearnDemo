package algorithm;

import java.util.Arrays;

/**
 * @Description: 快速排序，以轴为区分，轴左边的都比轴小，轴右边的都比轴大
 * @author: zpli
 * @Date: 2020/6/1 16:19
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {49, 5, 2, 38, 65, 97, 23, 49, 22, 76, 1, 5, 8, 2, 0, -1, 49, 22};
        // int[] arr = {49, 2, 38, 65, 97, 23, 22, 76, 1, 5, 8, 0, -1};
        // int[] arr = new int[]{2, 3, 5, 7, 1, 4, 6};
        System.out.println("快速排序前:" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int L = left, R = right, pivot = arr[L];
        while (L < R) {
            while (L < R && arr[R] >= pivot) {
                R--;
            }
            if (L < R) {
                arr[L++] = arr[R];
            }

            while (L < R && arr[L] <= pivot) {
                L++;
            }
            if (L < R) {
                arr[R--] = arr[L];
            }
        }
        arr[L] = pivot;
        quickSort(arr, left, L - 1);
        quickSort(arr, L + 1, right);
    }

}
