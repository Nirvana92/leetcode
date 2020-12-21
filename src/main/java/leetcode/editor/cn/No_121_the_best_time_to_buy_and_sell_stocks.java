package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/9/14 8:27 下午
 * @desc: 121. 买卖股票的最佳时机
 */
public class No_121_the_best_time_to_buy_and_sell_stocks {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 2, 3, 5, 6};
        No_121_the_best_time_to_buy_and_sell_stocks no_121 = new No_121_the_best_time_to_buy_and_sell_stocks();
        int maxProfit = no_121.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minVal = Integer.MAX_VALUE;

        int maxProfit = 0;
        for (int day = 0; day < prices.length; day++) {
            if (prices[day] > minVal) {
                maxProfit = Math.max(maxProfit, prices[day] - minVal);
            } else {
                minVal = Math.min(minVal, prices[day]);
            }
        }

        return maxProfit;
    }
}
