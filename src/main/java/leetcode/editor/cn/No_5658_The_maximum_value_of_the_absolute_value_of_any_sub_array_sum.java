package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

/**
 * @author gzm
 * @date 2021/2/7 9:55 上午
 * @desc: 5658. 任意子数组和的绝对值的最大值
 */
public class No_5658_The_maximum_value_of_the_absolute_value_of_any_sub_array_sum {
    @Test
    public void test() {
        int[] nums = new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};

        int maxAbsoluteSum = maxAbsoluteSum(nums);
        System.out.println(maxAbsoluteSum);
        int baoli = baoli(nums);
        System.out.println(baoli);
    }

    @Test
    public void t() {
        int times = 100000;

        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 10, -10, 10);
            int baoli = baoli(nums);
            int maxAbsoluteSum = maxAbsoluteSum(nums);

            if (baoli != maxAbsoluteSum) {
                PrintUtils.print(nums);
                System.out.println("baoli: " + baoli);
                System.out.println("maxAbsoluteSum: " + maxAbsoluteSum);
                break;
            }
        }
    }

    public int baoli(int[] nums) {
        int maxVal = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                maxVal = Math.max(maxVal, Math.abs(sum));
            }
        }

        return maxVal;
    }

    /**
     * 设置一个最大值的dp一个最小值的dp
     *
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
        // int preVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
            if (i > 0) {
                // preVal + nums(i)
                maxDp[i] = Math.max(maxDp[i], maxDp[i - 1] + nums[i]);
                minDp[i] = Math.min(minDp[i], minDp[i - 1] + nums[i]);
            }

            maxVal = Math.max(maxVal, maxDp[i]);
            minVal = Math.min(minVal, minDp[i]);
        }

        return Math.max(Math.abs(maxVal), Math.abs(minVal));
    }
}
