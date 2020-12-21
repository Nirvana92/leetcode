package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，
 * 将该数组按峰与谷的交替顺序排序。
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 */
public class Interview_questions_10_11_Peaks_and_valleys {
    @Test
    public void test() {
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        PrintUtils.print(nums);
    }

    /**
     * 峰谷峰 的方式往后排
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        if (nums.length <= 2) {
            return;
        }

        // 是否是波峰
        boolean preIsCrest = nums[1] > nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (preIsCrest) {
                // 谷
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                // 峰
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }

            preIsCrest = !preIsCrest;
        }
    }

    public void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
