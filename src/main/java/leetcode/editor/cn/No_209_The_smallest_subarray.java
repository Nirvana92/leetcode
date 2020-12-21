package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/15 10:22 上午
 * @desc: 209. 长度最小的子数组
 * <p>
 * 209. 长度最小的子数组
 * *
 * * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * * 示例: 
 * *
 * * 输入: s = 7, nums = [2,3,1,2,4,3]
 * * 输出: 2
 * * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * * 进阶:
 */
public class No_209_The_smallest_subarray {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1};
        int s = 7;
        int minSubArrayLen = minSubArrayLen(s, nums);
        System.out.println(minSubArrayLen);
    }

    public int minSubArrayLen(int s, int[] nums) {
        // 添加辅助数组
        int[] sums = new int[nums.length + 1];
        // 初始化累加和数组
        int preVal = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int R = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            while (R < nums.length && sums[R] - sums[i] < s) {
                R++;
            }

            // 统计最小长度
            if (sums[R] - sums[i] >= s) {
                minLen = Math.min(minLen, R - i);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
