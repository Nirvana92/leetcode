package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/21 22:50
 * <p>
 * 746. 使用最小花费爬楼梯
 */
public class No_746_Climb_stairs_with_minimal_cost {
    @Test
    public void test() {
        int[] cost = new int[]{10, 15, 20};

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        cost = new int[]{1, 2};

        int minCostClimbingStairs = minCostClimbingStairs(cost);
        System.out.println(minCostClimbingStairs);

        int minCostClimbingStairsDp = minCostClimbingStairsDp(cost);
        System.out.println(minCostClimbingStairsDp);
    }

    /**
     * 改写的动态规划版本
     *
     * @param cost
     * @return
     */
    int minCostClimbingStairsDp(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N + 2];
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1] + cost[i], dp[i + 2] + cost[i]);
        }

        return Math.min(dp[0], dp[1]);
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(process(cost, 0), process(cost, 1));
    }

    int process(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        // 跳一步, 跳两步
        int p1 = process(cost, i + 1) + cost[i];
        int p2 = process(cost, i + 2) + cost[i];

        return Math.min(p1, p2);
    }
}
