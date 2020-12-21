package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/25 16:16
 * <p>
 * 540. 有序数组中的单一元素
 * <p>
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * todo: 题目要求通过实践复杂度为O(logn) 来完成。可以考虑二分查找方法
 */
public class No_540_A_single_element_in_an_ordered_array {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int singleNonDuplicate = singleNonDuplicate(nums);
        System.out.println(singleNonDuplicate);
    }

    public int singleNonDuplicate(int[] nums) {
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            rst ^= nums[i];
        }

        return rst;
    }
}
