package algorithm;

/**
 * @Description: 二分查找
 * @author: zpli
 * @Date: 2020/6/1 9:30
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 5, 7, 8, 9};
        int digest = 4;
        System.out.println(binarySearch(arr, digest));
    }

    public static int binarySearch(int[] arr, int digest) {
        int low = 0, high = arr.length - 1;

        while (low <= high && digest >= arr[low] && digest <= arr[high]) {
            if (digest == arr[low])
                return low;
            if (digest == arr[high])
                return high;

            int mid = low + (high - low) / 2;
            if (arr[mid] == digest) {
                return mid;
            } else if (arr[mid] < digest) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
