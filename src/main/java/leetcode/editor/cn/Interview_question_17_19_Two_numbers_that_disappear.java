package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/29 3:31 下午
 * @desc: 面试题 17.19. 消失的两个数字
 * <p>
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例:
 * 输入: [1]
 * 输出: [2,3]
 */
public class Interview_question_17_19_Two_numbers_that_disappear {
    @Test
    public void test() {
        int[] nums = new int[]{1};
        nums = new int[]{2, 3};
        nums = new int[]{2};
        nums = new int[]{3};
        nums = new int[]{1, 2, 3, 4, 6, 7, 9, 10};

        int[] missingTwo = missingTwo(nums);
        PrintUtils.print(missingTwo);
    }

    public int[] missingTwo(int[] nums) {
        int N = nums.length;

        int twoNumIndex = 0, maxVal = 0;
        int wishSumVal = 0, sumVal = 0;
        for (int i = 0; i < N; i++) {
            wishSumVal += i + 1;
            sumVal += nums[i];
        }

        int missTwoSum = wishSumVal + N + 1 + N + 2 - sumVal;
        int[] twoNums = new int[2];

        for (int i = 0; i < N; i++) {
            while (nums[i] != i + 1 && nums[i] - 1 < N) {
                maxVal = Math.max(maxVal, nums[i]);
                // 对应的位置对不上数据
                swap(nums, i, nums[i] - 1);
            }
            maxVal = Math.max(maxVal, nums[i]);
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) {
                twoNums[twoNumIndex++] = i + 1;
            }
        }
        if (twoNumIndex == 2) {
            return twoNums;
        }

        if (twoNumIndex == 0) {
            twoNums[twoNumIndex++] = N + 1;
        }
        twoNums[twoNumIndex] = missTwoSum - twoNums[0];

        return twoNums;
    }

    public void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
