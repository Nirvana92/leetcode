package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/27 11:19 上午
 * @desc: 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Offer_57_And_two_numbers_with_s {
    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        nums = new int[]{10, 26, 30, 31, 47, 60};
        target = 40;

        int[] twoSum = twoSum(nums, target);
        PrintUtils.print(twoSum);
    }

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{};
    }
}
