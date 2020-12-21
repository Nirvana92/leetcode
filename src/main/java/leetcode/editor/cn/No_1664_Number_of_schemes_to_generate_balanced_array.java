package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/1 9:54 上午
 * @desc: 1664. 生成平衡数组的方案数
 */
public class No_1664_Number_of_schemes_to_generate_balanced_array {
    @Test
    public void test() {
        int[] nums = new int[]{2, 1, 6, 4};
        // nums = new int[]{1, 1, 1};
        nums = new int[]{1, 2, 3};

        int waysToMakeFair = waysToMakeFair(nums);
        System.out.println(waysToMakeFair);
    }

    public int waysToMakeFair(int[] nums) {
        // 收集当前往后的技术下标和偶数下标的类和
        int evenSum = 0, oddSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }

        int ret = 0;
        int curEvenSum = 0, curOddSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // 当前下标偶数位下标
                evenSum -= nums[i];
                if (curEvenSum + oddSum == curOddSum + evenSum) {
                    ret++;
                }
                curEvenSum += nums[i];
            } else {
                // 奇数位下标
                oddSum -= nums[i];
                if (curEvenSum + oddSum == curOddSum + evenSum) {
                    ret++;
                }
                curOddSum += nums[i];
            }
        }

        return ret;
    }
}
