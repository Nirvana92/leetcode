package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/2/28 21:07
 * <p>
 * 896. 单调数列
 */
public class No_896_Monotonic_sequence {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2, 3};
        nums = new int[]{6, 5, 4, 4};
        nums = new int[]{1, 3, 2};
        nums = new int[]{1, 2, 4, 5};
        nums = new int[]{1, 1, 1};

        boolean b = isMonotonic(nums);
        System.out.println(b);
    }

    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) {
            return true;
        }

        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                // 标记result 1 位
                result |= 1;
            } else if (A[i] < A[i - 1]) {
                // 标记 result 2 位
                result |= 2;
            }
        }

        return result < 3;
    }
}
