package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/12/17 2:57 下午
 * @desc: 1685. 有序数组中差绝对值之和
 */
public class No_1685_The_sum_of_absolute_differences_in_an_ordered_array {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 5};
        nums = new int[]{1, 4, 6, 8, 10};

        int[] sumAbsoluteDifferences = getSumAbsoluteDifferences(nums);
        PrintUtils.print(sumAbsoluteDifferences);
    }

    /**
     * 根据题目中提示的非递减可以发现:
     * 1. 如果求解当前的位置  i
     * 2. < i 的位置都是小与当前的值
     * 3. > i 的位置都是大于当前的值
     * 所以可以通过 < i 的值的总和 求解, 以及 > i 的值求解
     *
     * @param nums
     * @return
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int N = nums.length;
        int[] rets = new int[N];

        int rToLSum = 0;
        for (int num : nums) {
            rToLSum += num;
        }

        int lToRSum = 0;
        for (int i = 0; i < N; i++) {
            rToLSum -= nums[i];

            rets[i] += nums[i] * i - lToRSum;
            rets[i] += rToLSum - nums[i] * (N - i - 1);

            lToRSum += nums[i];
        }
        return rets;
    }
}
