package algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/30 14:10
 */
public class Offer_40_LeastNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{1, 3, 5, 2}, 2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k, (n1, n2) -> n2 - n1);
        for (int num : arr) {
            if (maxQueue.size() < k)
                maxQueue.offer(num);
            else if (maxQueue.peek() > num) {
                maxQueue.poll();
                maxQueue.offer(num);
            }
        }

        int[] result = new int[k];
        int idx = 0;
        for (int num : maxQueue) {
            result[idx++] = num;
        }
        return result;
    }
}
