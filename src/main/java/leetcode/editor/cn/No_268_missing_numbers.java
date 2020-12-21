package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/21 8:06 下午
 * @desc
 */
public class No_268_missing_numbers {
    @Test
    public void test() {
        int[] nums = new int[]{9, 6, 8, 2, 3, 5, 7, 4, 0};
        nums = new int[]{1};
        int missNum = missingNumber(nums);
        System.out.println(missNum);
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        int changeVal = 0;
        for (int i = 0; i < N; i++) {
            while (nums[i] != i && nums[i] < N) {
                changeVal = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = changeVal;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return N;
    }
}
