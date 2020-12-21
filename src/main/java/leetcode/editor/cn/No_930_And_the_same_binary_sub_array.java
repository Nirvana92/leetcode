package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/27 8:42 下午
 * @desc: 930. 和相同的二元子数组
 */
public class No_930_And_the_same_binary_sub_array {
    @Test
    public void test() {
        int[] nums = new int[]{};
        int s = 2;
        int numSubarraysWithSum = numSubarraysWithSum(nums, s);
        System.out.println(numSubarraysWithSum);
    }

    public int numSubarraysWithSum(int[] nums, int s) {
//        int numSubArrs = 0;
//
//        int r = 0, sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (sum > s && r < nums.length) {
//                sum += nums[r];
//                r++;
//            }
//
//            while (sum == s) {
//
//            }
//        }

        return 1;
    }
}
