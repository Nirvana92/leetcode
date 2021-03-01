package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/1 9:49 上午
 * @desc: 303. 区域和检索 - 数组不可变
 */
public class No_303_Regions_and_retrieval_immutable_arrays {
    @Test
    public void test() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);
        int i = 0, j = 2;
        i = 2;
        j = 5;

        i = 0;
        j = 5;

        int sumRange = numArray.sumRange(i, j);
        System.out.println(sumRange);
    }
}

class NumArray {
    int[] sums = null;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    /**
     * 求得 i...j 的总和: sums[j] - sums[i-1]
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        if (i - 1 >= 0) {
            return sums[j] - sums[i - 1];
        } else {
            return sums[j];
        }
    }
}