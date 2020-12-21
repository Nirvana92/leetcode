package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/11/5 8:43 下午
 * @desc: 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * 参考: {@link No_137_Number_that_appears_only_once_II}
 */
public class Offer_56_1_Number_of_occurrences_of_numbers_in_the_array {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // 此时xor 为两个个数为一的数的异或结果

        // 求取 xor 的最右的位为1 的值
        int rightBit = xor & (~xor + 1);

        // 两个不同的值的位置区分整个数组的数据
        int tmpXor = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((rightBit & nums[i]) == rightBit) {
                tmpXor ^= nums[i];
            }
        }

        int[] rsts = new int[2];
        rsts[0] = tmpXor;
        rsts[1] = tmpXor ^ xor;

        return rsts;
    }
}
