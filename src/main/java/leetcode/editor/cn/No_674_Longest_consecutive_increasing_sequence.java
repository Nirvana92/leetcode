package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/8 21:25
 * <p>
 * 674. 最长连续递增序列
 */
public class No_674_Longest_consecutive_increasing_sequence {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        nums = new int[]{2, 2, 2, 2, 2};

        int lengthOfLCIS = findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }

    public int findLengthOfLCIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return N;
        }

        int maxLen = 1;
        int preMaxLen = 1;

        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                preMaxLen = preMaxLen + 1;
            } else {
                preMaxLen = 1;
            }

            maxLen = Math.max(maxLen, preMaxLen);
        }

        return maxLen;
    }
}
