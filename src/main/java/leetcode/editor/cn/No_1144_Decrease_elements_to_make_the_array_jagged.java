package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/29 5:11 下午
 * @desc: 1144. 递减元素使数组呈锯齿状
 */
public class No_1144_Decrease_elements_to_make_the_array_jagged {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        // nums = new int[]{9, 6, 1, 6, 2};
        // nums = new int[]{3, 7, 78, 98, 78, 78, 333, 23};

        int movesToMakeZigzag = movesToMakeZigzag(nums);
        System.out.println(movesToMakeZigzag);
    }

    public int movesToMakeZigzag(int[] nums) {
        int N = nums.length;
        if (N <= 2) {
            return 0;
        }

        // 奇数, 偶数
        int oddMoves = 0, evenMoves = 0;
        for (int i = 0; i < N; i++) {
            int minDiffVal = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                minDiffVal = nums[i - 1];
            }

            if (i + 1 < N) {
                minDiffVal = Math.min(minDiffVal, nums[i + 1]);
            }

            if ((i & 1) == 1) {
                // 奇数
                oddMoves += Math.max((nums[i] - minDiffVal + 1), 0);
            } else {
                // 偶数
                evenMoves += Math.max((nums[i] - minDiffVal + 1), 0);
            }
        }

        return Math.min(oddMoves, evenMoves);
    }
}
