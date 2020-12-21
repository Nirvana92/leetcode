package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/20 8:27 下午
 * @desc: 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class Offer_42_Maximum_sum_of_consecutive_subarrays {
    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        nums = new int[]{};

        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    public int maxSubArray(int[] nums) {
        // 遍历 nums, 以nums 中的每个位置为开始点到 nums.len 最长的连续和. 然后统计每次i 的最大值, 返回
        int N = nums.length;
        if (N == 0 || N == 1) {
            return N == 0 ? Integer.MIN_VALUE : nums[0];
        }

        int preSubArraySum = nums[N - 1];
        int maxSubSum = preSubArraySum;
        for (int i = N - 2; i >= 0; i--) {
            preSubArraySum = Math.max(nums[i], nums[i] + preSubArraySum);
            maxSubSum = Math.max(maxSubSum, preSubArraySum);
        }

        return maxSubSum;
    }
}
