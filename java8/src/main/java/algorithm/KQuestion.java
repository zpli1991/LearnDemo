package algorithm;

import java.util.*;

/**
 * @Description: 求第K大或者第K小的数，使用快速排序的思想
 * @author: zpli
 * @Date: 2020/6/5 10:36
 */
public class KQuestion {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{3, 5, 7, 2, 6};
        int kQuestion = kQuestion(arr, 2, 0, arr.length - 1);
        System.out.println(kQuestion);
        // int kMin = kMin(arr, 3);
        // int kMax = kMax(arr,2);
        // System.out.println(kMin);
        // System.out.println(kMax);
    }

    public static int kQuestion(int[] arr, int digest, int left, int right) throws Exception {
        int L = left, R = right,  povit= arr[L];
        while (L < R) {
            while (L < R && arr[R] >= povit)
                R--;
            if (L < R)
                arr[L++] = arr[R];
            while (L < R && arr[L] <= povit)
                L++;
            if (L < R)
                arr[R--] = arr[L];
        }
        arr[L] = povit;
        if (L == digest - 1)
            return povit;
        else if (L > digest - 1)
            return kQuestion(arr, digest, left, L - 1);
        else
            return kQuestion(arr, digest, L + 1, right);
    }

    public static int kMin(int[] arr, int digest) {
        Queue<Integer> queue = new PriorityQueue<>(digest, (n1, n2) -> n2 - n1);
        for (int num : arr) {
            if (queue.size() < digest) {
                queue.offer(num);
            } else {
                if ((queue.peek() > num)) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        System.out.println("==================");
        for (int temp : queue) {
            System.out.println(temp);
        }
        System.out.println("==================");
        return queue.peek();
    }

    public static int kMax(int[] arr, int digest) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            if (queue.size() < digest) {
                queue.offer(num);
            } else {
                if ((queue.peek() < num)) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        System.out.println("==================");
        for (int temp : queue) {
            System.out.println(temp);
        }
        System.out.println("==================");
        return queue.peek();
    }
}
