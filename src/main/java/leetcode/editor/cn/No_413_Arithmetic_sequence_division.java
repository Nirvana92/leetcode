package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/15 22:02
 * <p>
 * 413. 等差数列划分
 * <p>
 * 动态规划
 */
public class No_413_Arithmetic_sequence_division {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 7, 9, 11, 13, 14, 15, 16};

        int numberOfArithmeticSlices = numberOfArithmeticSlices(nums);
        System.out.println(numberOfArithmeticSlices);

        int numberOfArithmeticSlicesDp = numberOfArithmeticSlicesDp(nums);
        System.out.println(numberOfArithmeticSlicesDp);
    }

    /**
     * 动态规划版本。可以优化dp 的长度。字节保存前一个dp值就好
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlicesDp(int[] nums) {
        int N = nums.length;
        if (N < 3) {
            return 0;
        }
        int[] dp = new int[N];

        int ret = 0;
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }

            ret += dp[i];
        }

        return ret;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;

        int ret = 0;
        for (int s = 0; s < N; s++) {
            for (int e = s + 2; e < N; e++) {
                boolean canAdd = true;
                for (int i = s + 1; i < e; i++) {
                    if (nums[i] - nums[i - 1] != nums[i + 1] - nums[i]) {
                        canAdd = false;
                        break;
                    }
                }

                ret += canAdd ? 1 : 0;
            }
        }

        return ret;
    }
}
