package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/11/5 6:00 下午
 * @desc: 剑指 Offer 03. 数组中重复的数字
 */
public class Offer_03_Repeated_numbers_in_the_array {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> sets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) {
                return nums[i];
            }

            sets.add(nums[i]);
        }

        return -1;
    }
}
