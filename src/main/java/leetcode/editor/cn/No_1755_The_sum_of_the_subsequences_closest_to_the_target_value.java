package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/2/9 2:10 下午
 * @desc: 1755. 最接近目标值的子序列和
 */
public class No_1755_The_sum_of_the_subsequences_closest_to_the_target_value {
    @Test
    public void test() {
        int[] nums = new int[]{};
        int goal = 10;

        int minAbsDifference = minAbsDifference(nums, goal);
        System.out.println(minAbsDifference);
    }

    public int minAbsDifference(int[] nums, int goal) {

        /**
         * dp[i]: nums[0...i]: 最接近的goal 的目标
         *
         */
        int[] dp = new int[nums.length];

        return -1;
    }


}
