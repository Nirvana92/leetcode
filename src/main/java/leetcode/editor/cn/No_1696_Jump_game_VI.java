package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.LinkedList;

/**
 * @author gzm
 * @date 2020/12/21 10:36 上午
 * @desc: 1696. 跳跃游戏 VI
 * <p>
 * 动态规划 + 滑动窗口
 */
public class No_1696_Jump_game_VI {
    @Test
    public void test() {
        int[] nums = new int[]{1, -1, -2, 4, -7, 3};
        int k = 2;

        nums = new int[]{10, -5, -2, 4, 0, 3};
        k = 3;

        nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
        k = 2;

        nums = new int[]{-5582, -5317, 6711, -639, 1001, 1845, 1728, -4575, -6066, -7770, 128, -3254, 7281, 3966, 6857, 5477, 8968, -1771, 9986, -6267, 9010, -764, 8413, -8154, 1087, -1107, 4183, 3033, 58, 659, 4625, 2825, 5031, 6811, 5657, 3229, 8597, -5772, 8869, 5723, 2960, 4040, 7222, 4841, -1014, 581, -2830, 3881, -3800, 577};
        k = 5;

        nums = new int[]{1, 2, 3, 4, 5, -1, -1, 80};
        k = 2;

        nums = new int[]{-9, -1, -9, 3, 17, 11, 19, -18, -1};
        k = 4;

        int maxResult = maxResult(nums, k);
        System.out.println(maxResult);

        int maxResultDp = maxResultDp(nums, k);
        System.out.println(maxResultDp);
    }

    @Test
    public void t() {
        int times = 10000;
        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 10, -20, 20);
            int k = Utils.generInt(1, nums.length);

            int maxResult = maxResult(nums, k);
            int maxResultDp = maxResultDp(nums, k);
            if (maxResult != maxResultDp) {
                PrintUtils.print(nums);
                System.out.println(k);
                System.out.println(maxResult);
                System.out.println(maxResultDp);
                System.out.println("error");
                break;
            }
        }
    }

    /**
     * dp 版本 + 滑动窗口处理
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxResultDp(int[] nums, int k) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }

        int[] dp = new int[N + 1];
        LinkedList<Integer> queues = new LinkedList<>();
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = nums[i] + (queues.isEmpty() ? 0 : dp[queues.peekFirst()]);
            while (!queues.isEmpty() && dp[queues.peekLast()] <= dp[i]) {
                queues.pollLast();
            }

            queues.addLast(i);

            if (queues.peekFirst() == i + k) {
                queues.pollFirst();
            }
        }

        return dp[0];
    }

    public int maxResult(int[] nums, int k) {
        // + nums[0]
        return process(nums, k, 0);
    }

    int process(int[] nums, int k, int index) {
        int N = nums.length;
        if (index == N - 1) {
            return nums[index];
        }
        if (index >= N) {
            return Integer.MIN_VALUE;
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            int nextRet = process(nums, k, index + i);

            if (nextRet == Integer.MIN_VALUE) {
                continue;
            }

            ret = Math.max(ret, nums[index] + nextRet);
        }

        return ret;
    }
}
