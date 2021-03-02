package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/2 8:25 下午
 * @desc: 1770. 执行乘法运算的最大分数
 * <p>
 * 动态规划求解: 通过参数求解省去一阶
 */
public class No_1770_Maximum_score_to_perform_multiplication {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        int[] multipliers = new int[]{3, 2, 1};

//        nums = new int[]{-5, -3, -3, -2, 7, 1};
//        multipliers = new int[]{-10, -5, 3, 4, 6};

        int maximumScore = maximumScore(nums, multipliers);
        System.out.println(maximumScore);

        int baoli = baoli(nums, multipliers);
        System.out.println(baoli);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int len = multipliers.length;
        int[][] dp = new int[len][len];

        // 先求dp 的第二个参数为mIndex-1 时候的结果
        for (int l = 0; l < len; l++) {
            int r = nums.length + l - len;
            // 计算最后一步的时候的结果值
            dp[l][len - 1] = Math.max(nums[l] * multipliers[len - 1], nums[r] * multipliers[len - 1]);
        }

        for (int mIndex = len - 2; mIndex >= 0; mIndex--) {
            // l 的长度不能超过mIndex
            for (int l = mIndex; l >= 0; l--) {
                int r = nums.length + l - mIndex - 1;
                dp[l][mIndex] = multipliers[mIndex] * nums[r] + dp[l][mIndex + 1];
                if (l + 1 < len) {
                    int p1 = multipliers[mIndex] * nums[l] + dp[l + 1][mIndex + 1];
                    dp[l][mIndex] = Math.max(p1, dp[l][mIndex]);
                }
            }
        }

        return dp[0][0];
    }

    /**
     * 递归求解方法
     *
     * @param nums
     * @param multipliers
     * @return
     */
    public int baoli(int[] nums, int[] multipliers) {
        return process(nums, multipliers, 0, 0);
    }

    /**
     * 在nums[l...r] 范围内, multipliers 当前的索引mIndex 得到的最大分数
     *
     * @param nums
     * @param multipliers
     * @param l
     * @param mIndex
     * @return
     */
    int process(int[] nums, int[] multipliers, int l, int mIndex) {
        // l + nums.length - 1 - r = mIndex
        // r 通过计算得出, 省去一阶
        int r = nums.length + l - mIndex - 1;
        if (mIndex >= multipliers.length) {
            return 0;
        }

        int p1 = multipliers[mIndex] * nums[l] + process(nums, multipliers, l + 1, mIndex + 1);
        int p2 = multipliers[mIndex] * nums[r] + process(nums, multipliers, l, mIndex + 1);
        return Math.max(p1, p2);
    }
}
