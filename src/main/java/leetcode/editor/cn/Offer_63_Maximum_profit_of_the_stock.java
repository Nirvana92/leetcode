package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/5 10:31 下午
 * @desc
 */
public class Offer_63_Maximum_profit_of_the_stock {
    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        prices = new int[]{7, 6, 4, 3, 1};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N == 0 || N == 1) {
            return 0;
        }

        int minVal = prices[0], maxProfit = 0;
        for (int i = 1; i < N; i++) {
            minVal = Math.min(minVal, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minVal);
        }

        return maxProfit;
    }
}
