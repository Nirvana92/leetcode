package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/2/28 01:29
 * <p>
 * 1760. 袋子里最少数目的球
 * <p>
 * 使用二分法遍历最大的球的数量的值。然后通过二分法一步步精确这个最小值
 */
public class No_1760_The_least_number_of_balls_in_the_bag {
    @Test
    public void test() {
        int[] nums = new int[]{9};
        int maxOperations = 3;

        nums = new int[]{2, 4, 8, 2};
        maxOperations = 4;

        nums = new int[]{7, 17};
        maxOperations = 2;

        int minimumSize = minimumSize(nums, maxOperations);
        System.out.println(minimumSize);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 1000000000;

        while (l < r) {
            int mid = (l + r) / 2;
            if (check(nums, mid, maxOperations)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean check(int[] nums, int maxNum, int maxOperations) {
        for (int num : nums) {
            if (num > maxNum) {
                maxOperations -= num / maxNum - (num % maxNum == 0 ? 1 : 0);
            }
        }

        return maxOperations >= 0;
    }
}
