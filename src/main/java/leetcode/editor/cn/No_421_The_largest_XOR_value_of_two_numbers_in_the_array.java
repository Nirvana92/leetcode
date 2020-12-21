package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/26 3:42 下午
 * @desc: 421. 数组中两个数的最大异或值
 * <p>
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * 你能在O(n)的时间解决这个问题吗？
 * <p>
 * todo: 前缀树处理
 */
public class No_421_The_largest_XOR_value_of_two_numbers_in_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        nums = new int[]{8, 10, 2};

        int maximumXOR = findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }

    public int findMaximumXOR(int[] nums) {
        return 1;
    }
}
