package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/16 22:46
 * <p>
 * 1658. 将 x 减到 0 的最小操作数
 * <p>
 * 滑动窗口
 */
public class No_1658_The_smallest_operand_that_reduces_x_to_0 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 4, 2, 3};
        int x = 5;

        nums = new int[]{5, 6, 7, 8, 9};
        x = 4;

        nums = new int[]{3, 2, 20, 1, 1, 3};
        x = 10;

        int minOperations = minOperations(nums, x);
        System.out.println(minOperations);
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }

        int target = sum - x;
        if (target < 0) {
            return -1;
        }

        int curVal = 0, r = 0, minOperation = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            while (r < N && curVal < target) {
                curVal += nums[r++];
            }

            if (curVal == target) {
                minOperation = Math.min(minOperation, N - r + i);
            }

            curVal -= nums[i];
        }

        return minOperation == Integer.MAX_VALUE ? -1 : minOperation;
    }
}
