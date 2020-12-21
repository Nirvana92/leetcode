package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/5 12:15 上午
 * @desc: 306. 累加数
 * <p>
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例:
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * <p>
 * todo: 题意理解错误; 每个数应该是前面两个数的累加和
 */
public class No_306_Accumulative_number {
    @Test
    public void test() {
        String num = "112358";
        num = "199100199";
        boolean additiveNumber = isAdditiveNumber(num);
        System.out.println(additiveNumber);
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        return process(num, 0);
    }

    /**
     * nums[l ... len] 是否可以满足条件
     *
     * @param nums
     * @param l
     * @return
     */
    boolean process(String nums, int l) {
        // 过滤条件
        if (l == nums.length()) {
            return true;
        }
        if (nums.length() - l < 3) {
            return false;
        }

        for (int endIndex = l + 3 - 1; endIndex < nums.length(); endIndex++) {
            if (isAddStr(nums, l, endIndex) && process(nums, endIndex + 1)) {
                return true;
            }
        }

        return false;
    }

    boolean isAddStr(String nums, int l, int r) {
        if (nums.charAt(l) == '0') {
            return false;
        }
        for (int firstNumEndIndex = l; firstNumEndIndex <= r - 2 && nums.charAt(firstNumEndIndex + 1) != '0'; firstNumEndIndex++) {
            // 遍历第一个数的范围
            for (int secondNumEndIndex = firstNumEndIndex + 1; secondNumEndIndex <= r - 1 && nums.charAt(secondNumEndIndex + 1) != '0'; secondNumEndIndex++) {
                // 遍历第二个数的范围
                if (strAdd(nums, l, firstNumEndIndex, secondNumEndIndex, r)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 两个字符串相加
     *
     * @param nums
     * @param l
     * @param fEnd:      第一个数结尾的下标索引
     * @param secondEnd: 第二个数的结尾的下标索引
     * @param r:         所有数的范围结束
     * @return
     */
    boolean strAdd(String nums, int l, int fEnd, int secondEnd, int r) {
        String first = nums.substring(l, fEnd + 1);
        String second = nums.substring(fEnd + 1, secondEnd + 1);
        String third = nums.substring(secondEnd + 1, r + 1);
        // System.out.println("first: " + first + ", second: " + second + ", third: " + third);

        return Integer.parseInt(first) + Integer.parseInt(second) == Integer.parseInt(third);
    }
}
