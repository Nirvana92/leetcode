package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/23 9:53 上午
 * @desc: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 */
public class Offer_53_Numbers_missing_from_0_n_1 {
    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        nums = new int[]{0, 1, 3};
        nums = new int[]{3, 2, 5, 1, 10, 6, 8, 0, 7, 9};
        nums = new int[]{0};

        int missingNumber = missingNumber(nums);
        System.out.println(missingNumber);
    }

    public int missingNumber(int[] nums) {
        int N = nums.length;
        int curIndex = 0, lastIndex = N - 1;
        while (curIndex < N) {
            if (nums[curIndex] == curIndex) {
                curIndex++;
            } else {
                if (nums[curIndex] > lastIndex) {
                    // 从lastIndex 往前推
                    swap(nums, curIndex++, lastIndex--);
                } else {
                    swap(nums, curIndex, nums[curIndex]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return N;
    }

    void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
