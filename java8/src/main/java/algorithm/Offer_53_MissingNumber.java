package algorithm;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/30 15:03
 */
public class Offer_53_MissingNumber {

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
