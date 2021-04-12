package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2021/4/8 9:51 上午
 * @desc: 1814. 统计一个数组中好对子的数目
 * <p>
 * <p>
 * 思路: 根据题意暴利求解的方法整体是O(n^2) 的复杂度。
 * 计算出每个数的与翻转数的差的绝对值。相同的差值可以组成好对。
 */
public class No_1814_Count_the_number_of_good_pairs_in_an_array {
    @Test
    public void test() {
        int[] nums = new int[]{42, 11, 1, 97};
        nums = new int[]{13, 10, 35, 24, 76};

        int countNicePairs = countNicePairs(nums);
        System.out.println(countNicePairs);

        System.out.println(Integer.MAX_VALUE);
    }

    public int countNicePairs(int[] nums) {
        int MOD = 1000_000_000 + 7;

        Map<Long, Long> countMaps = new HashMap<>();
        for (int num : nums) {
            long diffVal = getDiffVal(num);
            countMaps.put(diffVal, countMaps.getOrDefault(diffVal, 0L) + 1);
        }

        long nicePairs = 0;
        for (Map.Entry<Long, Long> entry : countMaps.entrySet()) {
            if (entry.getValue() > 1) {
                nicePairs += getNicePairs(entry.getValue() - 1);
                nicePairs %= MOD;
            }
        }

        return (int) nicePairs;
    }

    /**
     * 计算 1+2+...count 的和
     *
     * @param count
     * @return
     */
    long getNicePairs(long count) {
        return count * (count + 1) / 2;
    }

    long getDiffVal(long num) {
        long tmpVal = num;
        long reverseNum = 0;
        while (tmpVal > 0) {
            reverseNum = reverseNum * 10 + tmpVal % 10;
            tmpVal /= 10;
        }

        // return Math.abs(reverseNum - num);
        return reverseNum - num;
    }
}
