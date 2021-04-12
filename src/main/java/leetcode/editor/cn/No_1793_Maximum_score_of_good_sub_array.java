package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/16 10:36 上午
 * @desc: 1793. 好子数组的最大分数
 */
public class No_1793_Maximum_score_of_good_sub_array {
    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 3, 7, 4, 5};
        int k = 3;

        int maximumScore = maximumScore(nums, k);
        System.out.println(maximumScore);
    }

    /**
     * 第一种方法: 定义dp[i][j]: 表示下标i..j 中最小的数. 0<= i <=k. k<=j <=len-1[可能会超时]
     * 第二种方法: 以k 为控中心, 通过双指针的方法l, r. 如果nums[l] >= nums[k], l--. 如果nums[r] >= nums[k], r++
     * 依次遍历完整个数组. 找到最大的分数
     *
     * @param nums
     * @param k
     * @return
     */
    public int maximumScore(int[] nums, int k) {
        return -1;
    }
}
