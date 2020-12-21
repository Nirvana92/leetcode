package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/10/6 8:30 下午
 * @desc
 */
public class No_123_The_best_time_to_buy_and_sell_stocks_III {
    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int N = prices.length, k = 2;
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
