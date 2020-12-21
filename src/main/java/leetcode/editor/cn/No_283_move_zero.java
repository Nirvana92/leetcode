package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/9/21 8:47 下午
 * @desc
 */
public class No_283_move_zero {
    @Test
    public void test() {
        int[] nums = new int[]{1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int zeroIndex = 0, curIndex = 0, tmpVal = 0;
        int N = nums.length;
        while (curIndex < N) {
            if (nums[curIndex] != 0) {
                while (nums[zeroIndex] != 0 && zeroIndex < N - 1) {
                    zeroIndex++;
                }

                if (zeroIndex < curIndex) {
                    tmpVal = nums[curIndex];
                    nums[curIndex] = nums[zeroIndex];
                    nums[zeroIndex] = tmpVal;
                }
            }

            curIndex++;
        }
    }
}
