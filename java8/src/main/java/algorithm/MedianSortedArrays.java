package algorithm;

import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/29 14:48
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = (nums1.length + nums2.length) / 2;
        System.out.println(len);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>( (n1, n2) -> n2 - n1);
        for (int num : nums1) {
            if (minQueue.size() < len) {
                minQueue.offer(num);
            } else {
                if (minQueue.peek() < num) {
                    minQueue.poll();
                    minQueue.offer(num);
                }
            }
            if (maxQueue.size() < len) {
                maxQueue.offer(num);
            } else {
                if (maxQueue.peek() > num) {
                    maxQueue.poll();
                    maxQueue.offer(num);
                }
            }
        }
        for (int num : nums2) {
            if (minQueue.size() < len) {
                minQueue.offer(num);
            } else {
                if (minQueue.peek() < num) {
                    minQueue.poll();
                    minQueue.offer(num);
                }
            }
            if (maxQueue.size() < len) {
                maxQueue.offer(num);
            } else {
                if (maxQueue.peek() > num) {
                    maxQueue.poll();
                    maxQueue.offer(num);
                }
            }
        }
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }
}
