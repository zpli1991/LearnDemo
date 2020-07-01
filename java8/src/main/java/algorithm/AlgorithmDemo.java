package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/30 13:26
 */
public class AlgorithmDemo {

    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1, j = 1, sum = 0;

        while (i < target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] ary = new int[j - i];
                for (int k = i; k < j; k++) {
                    ary[k - i] = k;
                }
                result.add(ary);
                sum -= i;
                i++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}
