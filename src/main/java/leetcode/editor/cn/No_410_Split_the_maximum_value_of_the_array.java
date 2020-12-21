package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/15 20:32
 * <p>
 * 410. 分割数组的最大值
 * <p>
 * 动态规划 ;
 * 优化: 二分查找
 */
public class No_410_Split_the_maximum_value_of_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 3;

//        nums = new int[]{1, 4, 4};
//        m = 3;

//        nums = new int[]{2, 3, 1, 2, 4, 3};
//        m = 5;

        int splitArray = splitArray(nums, m);
        System.out.println(splitArray);

        int splitArrayTwoPoints = splitArrayTwoPoints(nums, m);
        System.out.println(splitArrayTwoPoints);
    }

    /**
     * 二分优化版本
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArrayTwoPoints(int[] nums, int m) {
        int l = 0, r = 0, mid = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l < r) {
            mid = l + (r - l) / 2;
            if (check(nums, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    boolean check(int[] nums, int m, int target) {
        int cnt = 1, sum = 0;
        for (int num : nums) {
            if (sum + num > target) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= m;
    }

    public int splitArray(int[] nums, int m) {
        int N = nums.length;
        int[][] dp = new int[N][m + 1];
        int[] sums = new int[N];
        sums[0] = nums[0];

        for (int i = 1; i < N; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        // dp[i][j]: 表示 nums[] 数组前i 个元素分成 j 份的目标结果值
        // 可能性:
        // 1. dp[i][j] = max(dp[j-1][j-1], sum[i]-sum[j-1])
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= Math.min(m - 1, i); j++) {
                if (j == 0) {
                    dp[i][j] = sums[i];
                } else {
                    dp[i][j] = Math.max(dp[j - 1][j - 1], sums[i] - sums[j - 1]);
                    for (int k = j; k <= i - 1; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sums[i] - sums[k]));
                    }
                }
            }
        }

        return dp[N - 1][m - 1];
    }
}
