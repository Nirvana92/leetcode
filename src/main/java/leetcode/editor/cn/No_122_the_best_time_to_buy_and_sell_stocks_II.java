package leetcode.editor.cn;

import org.junit.Test;

/**
 * 买卖股票的最佳时机 II
 */
public class No_122_the_best_time_to_buy_and_sell_stocks_II {
    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        prices = new int[]{1, 2, 3, 4, 5};
        prices = new int[]{7, 6, 4, 3, 1};
        prices = new int[]{};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        int maxProfit = 0;
        for (int day = 1; day < N; day++) {
            if (prices[day] > prices[day - 1]) {
                maxProfit += prices[day] - prices[day - 1];
            }
        }

        return maxProfit;
    }
}
