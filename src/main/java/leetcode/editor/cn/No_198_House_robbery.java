package leetcode.editor.cn;

import org.junit.Test;

import java.util.Random;

public class No_198_House_robbery {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 1, 1, 3, 1};
        Random random = new Random();
        int times = 100;
        for (int i = times; i > 0; i--) {
            int maxVal = random.nextInt(times);
            int maxLen = random.nextInt(times);
            // int[] nums = Utils.generIntArr(maxLen, maxVal);

            // int rob = rob(nums);
            int processDp = processDp(nums);
            System.out.println(processDp);
//            if (rob != processDp) {
//                System.out.println("=====");
//            }
        }
    }

    public int robDp(int[] nums) {
        return processDp(nums);
    }

    public int rob(int[] nums) {
        return process(nums, 0);
    }

    int processDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[N - 1] = nums[N - 1];
        int maxVal = dp[N - 1];
        for (int index = N - 2; index >= 0; index--) {
            // 选择 startIndex 位置的金额
            int p1 = dp[index + 2] + nums[index];
            // 不选择 startIndex 位置的金额
            int p2 = dp[index + 1];
            dp[index] = Math.max(p1, p2);

            maxVal = Math.max(maxVal, dp[index]);
        }

        return maxVal;
    }

    /**
     * nums[startIndex .....] 中得到的最大金额数
     *
     * @param nums
     * @param startIndex
     * @return
     */
    int process(int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            return 0;
        }

        // 选择 startIndex 位置的金额
        int p1 = process(nums, startIndex + 2) + nums[startIndex];

        // 不选择 startIndex 位置的金额
        int p2 = process(nums, startIndex + 1);

        return Math.max(p1, p2);
    }
}
