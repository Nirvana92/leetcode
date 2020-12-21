package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

/**
 * @author gzm
 * @date 2020/10/6 9:08 下午
 * @desc
 */
public class No_188_The_best_time_to_buy_and_sell_stock_IV {
    @Test
    public void test() {
//        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
//        int k = 2;
//        int maxProfit = maxProfit(k, prices);
//        int maxProfitDp = maxProfitDp(k, prices);
//        System.out.println(maxProfit);
//        System.out.println(maxProfitDp);


        int times = 10000000;
        while (times-- > 0) {
            int[] prices = Utils.generIntArr(10, 40);
            int k = Utils.generInt(1, 5);
            int maxProfit = maxProfit(k, prices);
            int maxProfitDp = maxProfitDp(k, prices);
            if (maxProfit != maxProfitDp) {
                System.out.println(maxProfit);
                System.out.println(maxProfitDp);
            }
        }
    }

    /**
     * 动态规划版本的代码
     * <p>
     * dp[i][k]: 表示 0...i 范围内, 进行最多k次交易获取的最大收益
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        if (N == 0 || N == 1) {
            return 0;
        }

        int[][] dp = new int[N][k + 1];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int p = 0; p <= i; p++) {
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + prices[i] - prices[p]);
                }
            }
        }

        return dp[N - 1][k];
    }

    /**
     * 上面dp版本中的迭代进行优化的版本
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitDp(int k, int[] prices) {
        int N = prices.length;
        if (N == 0 || N == 1) {
            return 0;
        }

        //等同于无限次的交易
        if (k >= N / 2) {
            int maxProfit = 0;
            for (int i = 1; i < N; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }

            return maxProfit;
        }

        int[][] dp = new int[k + 1][N];

        for (int i = 1; i <= k; i++) {
            int best = dp[i - 1][0] - prices[0];
            for (int j = 1; j < N; j++) {
                best = Math.max(best, dp[i - 1][j] - prices[j]);

                dp[i][j] = dp[i][j - 1];
                dp[i][j] = Math.max(dp[i][j - 1], best + prices[j]);
            }
        }

        return dp[k][N - 1];
    }
}
