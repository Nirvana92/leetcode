package leetcode.editor.cn;

import org.junit.Test;

/**
 * 312: 戳气球问题
 */
public class No_312_Poke_the_balloon {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 7, 9, 1};
        int maxCoins = maxCoins(nums);
        int maxCoinsBaoli = maxCoinsBaoli(nums);
        System.out.println(maxCoins);
        System.out.println(maxCoinsBaoli);
    }

    /**
     * 有可能是先打破 0 位置的或者 num.len-1 位置的
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int N = nums.length;

        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return nums[0];
        }

        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < N; i++) {
            help[i + 1] = nums[i];
        }

        int[][] dp = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = help[i - 1] * help[i] * help[i + 1];
        }

        for (int l = N; l >= 1; l--) {
            for (int r = l + 1; r <= N; r++) {
                int lastL = help[l] * help[l - 1] * help[r + 1] + dp[l + 1][r];
                int lastR = help[r] * help[l - 1] * help[r + 1] + dp[l][r - 1];
                int tmpMaxCoins = Math.max(lastL, lastR);

                for (int i = l + 1; i < r; i++) {
                    int tmpCoins = help[i] * help[l - 1] * help[r + 1] + dp[l][i - 1] + dp[i + 1][r];
                    tmpMaxCoins = Math.max(tmpMaxCoins, tmpCoins);
                }
                dp[l][r] = tmpMaxCoins;
            }
        }


        // int maxCoins = dp[1][N - 2] + Math.max(nums[0], nums[N - 1]) + nums[0] * nums[N - 1];
        return dp[1][N];
    }

    public int maxCoinsBaoli(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int maxCoins = process(nums, 1, nums.length - 2);
        maxCoins += Math.max(nums[0], nums[nums.length - 1]) + nums[0] * nums[nums.length - 1];
        return maxCoins;

    }

    /**
     * 在 nums[l...r] 范围内戳破所有的气球得到的最大硬币数
     * <p>
     * 按照先戳破的最后戳破的气球来区分:
     * <p>
     * l : nums[l] + process(nums, l+1, r)
     * r : nums[r] + process(nums, l, r-1)
     * i : nums[i]*nums[l]*nums[r] + process(nums, l, i-1) + process(nums, i+1, r)
     * 然后再求最大值返回
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    int process(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return nums[l] * nums[l - 1] * nums[r + 1];
        }

//        int lastL = nums[l] * nums[l - 1] * nums[r + 1] + process(nums, l + 1, r);
//        int lastR = nums[r] * nums[l - 1] * nums[r + 1] + process(nums, l, r - 1);

//        int maxCoins = Math.max(lastL, lastR);
        int maxCoins = 0;
        for (int i = l; i <= r; i++) {
            int tmpCoins = nums[i] * nums[l - 1] * nums[r + 1] + process(nums, l, i - 1) + process(nums, i + 1, r);
            maxCoins = Math.max(maxCoins, tmpCoins);
        }


        return maxCoins;
    }
}
