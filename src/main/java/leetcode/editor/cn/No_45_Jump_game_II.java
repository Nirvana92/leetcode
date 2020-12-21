package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

/**
 * @author gzm
 * @date 2020/10/22 2:21 下午
 * @desc: 45. 跳跃游戏 II
 * <p>
 * 每个 nums[i] 为非负整数。
 */
public class No_45_Jump_game_II {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        // nums = new int[]{3, 14, 5, 4, 6, 13, 13};
        // nums = new int[]{1, 9, 10, 10};
        // nums = new int[]{2, 2, 4, 11, 2, 11};

        int jump = jump(nums);
        System.out.println(jump);

        int jumpDp = jumpDp(nums);
        System.out.println(jumpDp);
    }

    @Test
    public void logarithm() {
        int times = 10000;

        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 10, 1, 15);
            int jump = jump(nums);
            int jumpDp = jumpDp(nums);
            if (jump != jumpDp) {
                System.out.println("jump: " + jump + "; jumpDp: " + jumpDp);
                PrintUtils.print(nums);
            }
        }
    }

    int jumpDp(int[] nums) {
        int N = nums.length;
        if (N == 0 || N == 1) {
            return 0;
        }

        if (nums[0] >= N - 1) {
            return 1;
        }

        // 依次找每次能跳的最大位置
        int minStep = 0, maxPosition = 0, endIndex = 0;
        for (int i = 0; i < N - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == endIndex) {
                endIndex = maxPosition;
                minStep++;
            }
        }

        return minStep;
    }

    public int jump(int[] nums) {
        return process(nums, 0);
    }

    int process(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }

        int minStep = Integer.MAX_VALUE;
        for (int nextStep = 1; nextStep <= nums[i]; nextStep++) {
            int nextMinStep = process(nums, i + nextStep);
            if (nextMinStep != Integer.MAX_VALUE) {
                minStep = Math.min(minStep, nextMinStep + 1);
            }
        }

        return minStep;
    }
}
