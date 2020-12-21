package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/9 12:55 下午
 * @desc: 1646. 获取生成数组中的最大值
 */
public class No_1646_Get_the_maximum_value_in_the_generated_array {
    @Test
    public void test() {

    }

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        int maxVal = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }

            maxVal = Math.max(maxVal, nums[i]);
        }

        return maxVal;
    }
}
