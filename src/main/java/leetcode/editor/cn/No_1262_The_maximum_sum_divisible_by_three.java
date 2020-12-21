package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

/**
 * @author Nirvana
 * @date 2020/10/18 22:38
 */
public class No_1262_The_maximum_sum_divisible_by_three {
    @Test
    public void test() {
        int[] nums = new int[]{3, 6, 5, 1, 8};

//        nums = new int[]{4};

//        nums = new int[]{1, 2, 3, 4, 4};

        int times = 1000;
        while (times-- > 0) {
            nums = Utils.generIntArr(10, 30);
            int maxSumDivThree = maxSumDivThree(nums);
//            System.out.println(maxSumDivThree);

            int processDp = processDp(nums);
//            System.out.println(processDp);

            if (maxSumDivThree != processDp) {
                System.out.println("===error");
            }
        }
    }

    int processDp(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }

        int[][] dp = new int[N + 1][3];
        dp[N][0] = 0;
        dp[N][1] = -1;
        dp[N][2] = -1;

        for (int i = N - 1; i >= 0; i--) {
            for (int residue = 0; residue < 3; residue++) {
                int p1 = dp[i + 1][(nums[i] + residue) % 3];
                if (p1 != -1) {
                    p1 += nums[i];
                }
                dp[i][residue] = Math.max(dp[i + 1][residue], p1);
            }
        }

        return dp[0][0];
    }

    public int maxSumDivThree(int[] nums) {
        int maxSum = process(nums, 0, 0);
        return maxSum == -1 ? 0 : maxSum;
    }

    /**
     * @param nums
     * @param i:       从i 开始往后
     * @param residue: 余数
     * @return: 返回的最大和
     */
    int process(int[] nums, int i, int residue) {
        if (i == nums.length && residue == 0) {
            return 0;
        }

        if (i == nums.length) {
            return -1;
        }

        // 选择
        int p1 = process(nums, i + 1, (nums[i] + residue) % 3);
        if (p1 != -1) {
            p1 += nums[i];
        }
        // 不选择
        int p2 = process(nums, i + 1, residue);

        return Math.max(p1, p2);
    }
}
