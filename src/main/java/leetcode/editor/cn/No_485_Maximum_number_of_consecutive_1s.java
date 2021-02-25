package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/2/15 12:01
 * <p>
 * 485. 最大连续1的个数
 */
public class No_485_Maximum_number_of_consecutive_1s {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1, 1};

        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;

        int tmpOnes = 0;
        for (int num : nums) {
            if (num == 0) {
                tmpOnes = 0;
            } else {
                tmpOnes++;
            }

            maxOnes = Math.max(maxOnes, tmpOnes);
        }

        return maxOnes;
    }
}
