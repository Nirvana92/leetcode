package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Nirvana
 * @date 2020/10/31 21:36
 * <p>
 * 628. 三个数的最大乘积
 */
public class No_628_Maximum_product_of_three_numbers {
    @Test
    public void test() {
        int[] nums = new int[]{};
        int maximumProduct = maximumProduct(nums);
        System.out.println(maximumProduct);
    }

    /**
     * 直接排序: 也可以线性时间复杂度得到答案
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[N - 1], nums[N - 1] * nums[N - 2] * nums[N - 3]);
    }
}
