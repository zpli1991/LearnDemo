package algorithm;

import java.util.Arrays;

/**
 * @Description: 合并两个有序数组
 * @author: zpli
 * @Date: 2020/7/3 10:17
 */
public class CombineSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 3, 5};
        int[] arr2 = {1, 2, 3, 4, 7};
        System.out.println(Arrays.toString(combineSortedArray(arr1, arr2)));
        System.out.println(Arrays.toString(combineSortedArr(arr1, arr2)));
    }

    private static int[] combineSortedArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int idx1 = 0, idx2 = 0, idxRes = 0;
        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] <= arr2[idx2]) {
                res[idxRes++] = arr1[idx1++];
            } else {
                res[idxRes++] = arr2[idx2++];
            }
        }
        while (idx1 < arr1.length) {
            res[idxRes++] = arr1[idx1++];
        }
        while (idx2 < arr2.length) {
            res[idxRes++] = arr2[idx2++];
        }
        return res;
    }

    private static int[] combineSortedArr(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length - 1, arr2Len = arr2.length - 1;
        int arrLen = arr1Len + arr2Len + 1;
        int[] res = new int[arrLen + 1];
        while (arr1Len >= 0 && arr2Len >= 0) {
            if (arr1[arr1Len] > arr2[arr2Len]) {
                res[arrLen--] = arr1[arr1Len--];
            } else {
                res[arrLen--] = arr2[arr2Len--];
            }
        }
        while (arr1Len >= 0) {
            res[arrLen--] = arr1[arr1Len--];
        }
        while (arr2Len >= 0) {
            res[arrLen--] = arr2[arr2Len--];
        }
        return res;
    }

}
