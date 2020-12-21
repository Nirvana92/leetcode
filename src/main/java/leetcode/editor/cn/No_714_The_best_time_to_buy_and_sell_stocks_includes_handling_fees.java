package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

/**
 * @author gzm
 * @date 2020/12/17 10:00 上午
 * @desc: 714. 买卖股票的最佳时机含手续费
 */
public class No_714_The_best_time_to_buy_and_sell_stocks_includes_handling_fees {
    @Test
    public void test() {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;

        prices = new int[]{1223, 1077, 4099, 4996};
        fee = 1950;

        int maxProfit = maxProfit(prices, fee);
        System.out.println(maxProfit);

        int maxProfitDp = maxProfitDp(prices, fee);
        System.out.println(maxProfitDp);
    }

    @Test
    public void t() {
        int times = 1000000;

        while (times-- > 0) {
            int[] prices = Utils.generIntArr(1, 50000, 1, 5000);
            int fee = Utils.generInt(0, 50000);

            int maxProfitDp = maxProfitDp(prices, fee);
            int maxProfit = maxProfit(prices, fee);
            if (maxProfitDp != maxProfit) {
                System.out.println("error");
                PrintUtils.print(prices);
                System.out.println(fee);
                System.out.println(maxProfitDp);
                System.out.println(maxProfit);
                break;
            }
        }
    }

    public int maxProfitDp(int[] prices, int fee) {
        int N = prices.length;
        if (N <= 1) {
            return 0;
        }

        int[] dp = new int[N + 1];
        int preMaxCommonVal = Integer.MIN_VALUE;
        for (int index = N - 1; index >= 0; index--) {
//            for (int i = index; i < N; i++) {
//                int curProfix = prices[i] - prices[index] - fee;
//                curProfix = Math.max(curProfix, 0);
//                dp[index] = Math.max(dp[index], curProfix + dp[i + 1]);
//            }

//            if (index == N - 2) {
//                dp[index] = Math.max(0, prices[index + 1] - fee + dp[index + 2] - prices[index]);
//            } else {
//                dp[index] = Math.max(dp[index + 1] == 0 ? -fee : dp[index + 1] + prices[index + 1] - prices[index], prices[index + 1] - fee + dp[index + 2] - prices[index]);
//                dp[index] = Math.max(dp[index], 0);
//            }

            /**
             * 通过递归方法可以归纳出, 每个dp[index] 都有共同的内容 [prices[index] + dp[index + 1] - fee] , 所以直接取出来, 然后再进行求最大值
             */
            preMaxCommonVal = Math.max(preMaxCommonVal, prices[index] + dp[index + 1] - fee);
            dp[index] = Math.max(preMaxCommonVal - prices[index], dp[index + 1]);
        }

        return dp[0];
    }

    public int maxProfit(int[] prices, int fee) {
        return process(prices, fee, 0);
    }

    int process(int[] prices, int fee, int index) {
        if (index == prices.length) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = index; i < prices.length; i++) {
            int curProfix = prices[i] - prices[index] - fee;
            curProfix = Math.max(curProfix, 0);
            maxProfit = Math.max(maxProfit, curProfix + process(prices, fee, i + 1));
        }

        return maxProfit;
    }
}
