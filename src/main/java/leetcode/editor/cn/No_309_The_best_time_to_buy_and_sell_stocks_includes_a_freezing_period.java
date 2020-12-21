package leetcode.editor.cn;

import org.junit.Test;

import java.util.Map;

/**
 * @author gzm
 * @date 2020/10/5 12:34 上午
 * @desc: leetcode 12
 */
public class No_309_The_best_time_to_buy_and_sell_stocks_includes_a_freezing_period {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 0, 2};
        nums = new int[]{5, 4, 1, 3, 8, 5, 7, 8, 6, 2, 7, 5};
        nums = new int[]{6, 1, 6, 9, 14, 432, 75, 3446};
        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

    /**
     * 最终版本:
     * buy[i] 表示 0...i 最后一次是买入的操作, 最大收益
     * sell[i] 表示 0...i 最后一次是卖出的操作, 最大收益
     * <p>
     * buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
     * sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N == 0 || N == 1) {
            return 0;
        }
        int[] buy = new int[N];
        int[] sell = new int[N];

        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < N; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[N - 1];
    }

    int process(int[] prices, int endIndex, Map<Integer, Integer> dps) {
        // int N = prices.length;
        if (endIndex < 0) {
            return 0;
        }

        if (dps.containsKey(endIndex)) {
            return dps.get(endIndex);
        }

        int firstBuyIndex = findFirstBuyIndex(prices, endIndex), maxVal = 0;
        if (firstBuyIndex == endIndex) {
            maxVal = process(prices, firstBuyIndex - 1, dps);
        } else {
            maxVal = prices[endIndex] - prices[firstBuyIndex] + process(prices, firstBuyIndex - 2, dps);
            if (firstBuyIndex < endIndex) {
                int p2 = prices[endIndex] - prices[firstBuyIndex + 1] + process(prices, firstBuyIndex - 1, dps);
                maxVal = Math.max(maxVal, p2);
            }
        }

        dps.put(endIndex, maxVal);
        return maxVal;

    }

    int findFirstBuyIndex(int[] prices, int endIndex) {
        int startIndex = endIndex, preVal = prices[endIndex];
        for (int i = endIndex - 1; i >= 0; i--) {
            if (preVal > prices[i]) {
                startIndex = i;
                preVal = prices[i];
            } else {
                break;
            }
        }

        return startIndex;
    }
}
