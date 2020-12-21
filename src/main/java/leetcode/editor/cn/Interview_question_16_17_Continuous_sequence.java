package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/21 23:16
 * <p>
 * 面试题 16.17. 连续数列
 */
public class Interview_question_16_17_Continuous_sequence {
    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if (N == 0 || N == 1) {
            return N == 0 ? Integer.MIN_VALUE : nums[0];
        }

        int preMaxSub = nums[N - 1], maxSub = nums[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            preMaxSub = Math.max(nums[i], nums[i] + preMaxSub);
            maxSub = Math.max(maxSub, preMaxSub);
        }

        return maxSub;
    }
}
