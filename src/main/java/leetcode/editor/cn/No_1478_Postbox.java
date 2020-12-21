package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Nirvana
 * @date 2020/10/22 23:38
 * <p>
 * 1478. 安排邮筒
 * <p>
 * 给你一个房屋数组houses 和一个整数 k ，其中 houses[i] 是第 i 栋房子在一条街上的位置，现需要在这条街上安排 k 个邮筒。
 * 请你返回每栋房子与离它最近的邮筒之间的距离的 最小 总和。
 * 答案保证在 32 位有符号整数范围以内。
 * <p>
 * todo: 优化: 可以进行四边形不等式的优化
 */
public class No_1478_Postbox {
    @Test
    public void test() {
        int[] houses = new int[]{1, 4, 8, 10, 20};
        int k = 3;

        houses = new int[]{2, 3, 5, 12, 18};
        k = 2;

        houses = new int[]{7, 4, 6, 1};
        k = 1;

        int minDistance = minDistance(houses, k);
        System.out.println(minDistance);
    }

    public int minDistance(int[] houses, int k) {
        int N = houses.length;

        // 对houses 进行排序
        Arrays.sort(houses);

        // dp[i][j]: 表示 houses[0 ... i] 个居民点放置j个邮箱, 最短距离
        int[][] dp = new int[N][k + 1];
        int[][] onePostboxDp = getOnePostboxDp(houses);
        // 填充只有一个邮箱的时候的数据
        for (int i = 0; i < N; i++) {
            dp[i][1] = onePostboxDp[0][i];
        }
        // 然后求一个普遍的位置
        // dp[i][k]: 讨论 第k 个邮箱摆放的位置, 然后结合之前的数据情况求得结果
        for (int i = 1; i < N; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {

                dp[i][j] = onePostboxDp[0][i];
                for (int n = i; n > 0; n--) {
                    dp[i][j] = Math.min(dp[i][j], dp[n - 1][j - 1] + onePostboxDp[n][i]);
                }
            }
        }

        return dp[N - 1][k];
    }

    /**
     * 先求一个辅助数据 dp[i][j] : 标识i ~ j位置上放一个邮箱, 最短的距离
     *
     * @param houses
     * @return
     */
    int[][] getOnePostboxDp(int[] houses) {
        int N = houses.length;
        int[][] onePostboxDp = new int[N][N];
        // 初始化 i == j 位置的最短距离

        // 先求一个累加和辅助数组
        // i > j 是不需要考虑的情况, 只用onePostboxDp 右上半区
        // 最短的距离一定是将邮局放在某个居民点上
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                onePostboxDp[i][j] = onePostboxDp[i][j - 1] + houses[j] - houses[(j + i) >> 1];
            }
        }

        return onePostboxDp;
    }
}
