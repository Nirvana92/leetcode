package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

public class No_80_Delete_duplicates_in_sorted_array_II {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        //nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int removeDuplicates = removeDuplicates(nums);
        System.out.println(removeDuplicates);
        PrintUtils.print(nums);
    }

    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        if (nums.length <= 2) {
            return N;
        }

        // validIndex: 去重之后的最新的有效下标
        // curIndex: 遍历的下标
        // preNumCount: 前一个数相同的个数
        int preNum = nums[0], validIndex = 0, preNumCount = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] == preNum) {
                preNumCount++;
            } else {
                preNum = nums[i];
                preNumCount = 1;
            }

            // 判断是否需要去重操作

            if (preNumCount <= 2) {
                validIndex++;
            }

            nums[validIndex] = nums[i];
        }

        return validIndex + 1;
    }
}
