package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

public class No_260_The_number_that_appears_only_once_III {
    @Test
    public void test() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] ints = singleNumber(nums);
        PrintUtils.print(ints);
    }

    public int[] singleNumber(int[] nums) {
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
