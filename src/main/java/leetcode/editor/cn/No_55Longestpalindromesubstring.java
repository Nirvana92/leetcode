package leetcode.editor.cn;

import org.junit.Test;

public class No_55Longestpalindromesubstring {

    @Test
    public void test() {
        int[] nums = new int[]{0, 1};
        boolean canJump = canJump(nums);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }

        int maxIndex = nums[0];

        boolean canJumpToEnd = false;
        for (int i = 1; i < nums.length; i++) {
            if (maxIndex >= i) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }

        return maxIndex >= nums.length - 1;
    }
}
