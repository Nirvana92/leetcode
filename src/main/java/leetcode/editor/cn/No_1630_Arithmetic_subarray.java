package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzm
 * @date 2020/11/10 5:26 下午
 * @desc: 1630. 等差子数组[暴利方法]
 */
public class No_1630_Arithmetic_subarray {
    @Test
    public void test() {
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};

        List<Boolean> booleans = checkArithmeticSubarrays(nums, l, r);
        System.out.println(booleans);
    }

    /**
     * 直接暴利求解
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> rets = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arrs = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arrs);
            rets.add(check(arrs));
        }

        return rets;
    }

    boolean check(int[] arrs) {
        if (arrs.length <= 2) {
            return true;
        }

        int diffVal = arrs[1] - arrs[0];
        for (int l = 2; l < arrs.length; l++) {
            if (diffVal != arrs[l] - arrs[l - 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 重排列, 会错了题意[error]
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarraysDp(int[] nums, int[] l, int[] r) {
        int N = nums.length;

        boolean[][] dp = new boolean[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = row + 1; col < N; col++) {
                if (col > row + 1) {
                    dp[row][col] = (nums[col] - nums[col - 1] == nums[row + 1] - nums[row]) && dp[row][col - 1];
                } else {
                    // col = row + 1
                    dp[row][col] = true;
                }
            }
        }

        List<Boolean> rets = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            rets.add(dp[l[i]][r[i]]);
        }

        return rets;
    }
}
