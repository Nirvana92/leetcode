package leetcode.editor.cn;

import org.junit.Test;

public class No_416_Split_equal_and_subset {
    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 11, 5};
        nums = new int[]{1, 2, 3, 5};
        boolean canPartition = canPartition(nums);
        System.out.println(canPartition);
    }

    public boolean canPartition(int[] nums) {
        return process(nums, 0, 0, 0);
    }

    /**
     * l 位置的数累加到 sum_1 , sum_2 上到最后是否相等进行尝试
     *
     * @param nums
     * @param l
     * @param sum_1
     * @param sum_2
     * @return
     */
    boolean process(int[] nums, int l, int sum_1, int sum_2) {
        if (l == nums.length) {
            return sum_1 == sum_2;
        }

        for (int i = l; i < nums.length; i++) {
            // l位置的数加到 sum_1 上
            sum_1 += nums[l];
            if (process(nums, l + 1, sum_1, sum_2)) {
                return true;
            }
            sum_1 -= nums[l];

            // l 位置的数加到 sum_2 上
            sum_2 += nums[l];
            if (process(nums, l + 1, sum_1, sum_2)) {
                return true;
            }
            sum_2 -= nums[l];
        }

        return false;
    }
}
