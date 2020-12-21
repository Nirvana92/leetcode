package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
public class No_560_And_the_sub_array_of_K {
    public static void main(String[] args) {
        No_560_And_the_sub_array_of_K no_560 = new No_560_And_the_sub_array_of_K();
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int k = 0;
        int maxMethod = no_560.subarraySum(nums, k);
        int subarraySumK = no_560.subarraySumK(nums, k);
        System.out.println(maxMethod);
        System.out.println(subarraySumK);
    }

    /**
     * ac代码
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumK(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int maxMethod = 0;

        /**
         * key: 累加和 , value: 该累加和出现的次数
         */
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int curSum = preSum + nums[i];
            maxMethod += sums.getOrDefault(curSum - k, 0);

            sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
            preSum = curSum;
        }

        return maxMethod;
    }

    /**
     * 这个方法错误
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        // 整体思路: 遍历nums 以 l ... len 必选的情况下往后加到k的方法数
        // 添加一个辅助数组
        // int[] sums = new int[nums.length];
        int maxMethod = 0;

        /**
         * key: 累加和 , value: 该累加和出现的次数
         */
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int curSum = preSum + nums[i];

            if (sums.get(curSum - k) != null) {
                maxMethod++;
            }

            sums.put(curSum, i);
            preSum = curSum;
        }

        return maxMethod;
    }
}
