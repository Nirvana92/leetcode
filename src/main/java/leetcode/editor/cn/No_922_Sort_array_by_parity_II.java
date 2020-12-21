package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/11/12 9:40 上午
 * @desc: 922. 按奇偶排序数组 II
 */
public class No_922_Sort_array_by_parity_II {

    @Test
    public void test() {
        int[] nums = new int[]{4, 2, 5, 7};
        nums = new int[]{2, 3};

        int[] sortArrayByParityII = sortArrayByParityII(nums);
        PrintUtils.print(sortArrayByParityII);
    }

    public int[] sortArrayByParityII(int[] nums) {
        // 奇数, 偶数
        int oddIndex = -1, evenIndex = -2, curIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[curIndex] % 2 == 0) {
                // 偶数
                evenIndex += 2;
                swap(nums, evenIndex, curIndex);
                if (curIndex == evenIndex) {
                    curIndex--;
                }
            } else {
                // 奇数
                oddIndex += 2;
                swap(nums, oddIndex, curIndex);
                if (curIndex == oddIndex) {
                    curIndex--;
                }
            }
        }

        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
