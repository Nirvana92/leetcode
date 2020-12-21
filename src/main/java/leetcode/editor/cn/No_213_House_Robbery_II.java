package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/30 1:00 下午
 * @desc: 打家劫舍 II: 给定的房屋形成一个环的
 * <p>
 * 因为房屋组成了环装, 所以处理的方法可以分为两步:
 * p1: 不选择第一个房屋的最大值
 * p2: 不选择最后一个房屋的最大值
 * <p>
 * 返回两种情况的最大值
 */
public class No_213_House_Robbery_II {
    @Test
    public void test() {
        int[] nums = {2, 3, 2};
        nums = new int[]{1, 2, 3, 1};
        nums = new int[]{2, 7, 9, 3, 1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    /**
     * 因为房屋是围绕成为一个环, 所以可以求两个假设然后对比最大值
     * <p>
     * p1: 不选择第一个房间的最大值
     * p2: 选择最后一个房间的最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int N = nums.length;
        int[] noFirstDp = new int[N + 1];
        noFirstDp[N - 1] = nums[N - 1];
        // 不选择第一个房屋的最大值
        int noFirstMaxVal = noFirstDp[N - 1];
        for (int index = N - 2; index > 0; index--) {
            // 选择 startIndex 位置的金额
            int p1 = noFirstDp[index + 2] + nums[index];
            // 不选择 startIndex 位置的金额
            int p2 = noFirstDp[index + 1];
            noFirstDp[index] = Math.max(p1, p2);

            noFirstMaxVal = Math.max(noFirstMaxVal, noFirstDp[index]);
        }

        int[] noLastDp = new int[N + 1];
        noLastDp[0] = nums[0];
        // 不选择最后一个房屋的最大值
        noLastDp[1] = Math.max(nums[0], nums[1]);
        int noLastMaxVal = noLastDp[1];
        for (int index = 2; index < nums.length - 1; index++) {
            // 选择 startIndex 位置的金额
            int p1 = noLastDp[index - 2] + nums[index];
            // 不选择 startIndex 位置的金额
            int p2 = noLastDp[index - 1];
            noLastDp[index] = Math.max(p1, p2);

            noLastMaxVal = Math.max(noLastMaxVal, noLastDp[index]);
        }

        return Math.max(noFirstMaxVal, noLastMaxVal);
    }
}
