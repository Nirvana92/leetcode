package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/11/6 8:42 下午
 * @desc: 剑指 Offer 45. 把数组排成最小的数
 */
public class Offer_45_Arrange_the_array_into_the_smallest_number {
    public String minNumber(int[] nums) {
        String[] numStrs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < numStrs.length; i++) {
            buffer.append(numStrs[i]);
        }

        return buffer.toString();
    }
}
