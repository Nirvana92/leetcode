package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/1/1 21:03
 * <p>
 * 713. 乘积小于K的子数组
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 */
public class No_713_Sub_array_whose_product_is_less_than_K {
    @Test
    public void test() {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;

        nums = new int[]{1, 5, 9, 10, 6};
        k = 100;

        nums = new int[]{1, 2, 3};
        k = 1;

        int numSubarrayProductLessThanK = numSubarrayProductLessThanK(nums, k);
        System.out.println(numSubarrayProductLessThanK);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        long curSubarrayRet = 1L;

        int rIndex = -1, ret = 0;
        for (int i = 0; i < len; i++) {
            while (rIndex < len && curSubarrayRet < k) {
                rIndex++;
                if (rIndex < len) {
                    curSubarrayRet *= nums[rIndex];
                }
            }

            // 跳出循环的时候, 要么rIndex < len, 要么 curSubarrayRet >= k
            // 计算能存在的结果数
            ret += rIndex - i;

            curSubarrayRet /= nums[i];
        }

        return Math.max(ret, 0);
    }
}
