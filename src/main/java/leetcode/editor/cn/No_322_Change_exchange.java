package leetcode.editor.cn;

import org.junit.Test;

/**
 *
 */
public class No_322_Change_exchange {
    @Test
    public void test() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

//        coins = new int[]{2};
//        amount = 3;

//        coins = new int[]{1};
//        amount = 0;

//        coins = new int[]{1};
//        amount = 1;

//        coins = new int[]{1};
//        amount = 2;

        coins = new int[]{};
        amount = 11;

        int coinChange = coinChange(coins, amount);
        int processDp = coinChangeDp(coins, amount);
        System.out.println(coinChange);
        System.out.println(processDp);
    }

    public int coinChange(int[] coins, int amount) {
        return process(coins, amount, amount);
    }

    /**
     * 动态规划版本
     *
     * @param coins
     * @param amount
     * @return
     */
    int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int restCoin = 1; restCoin <= amount; restCoin++) {
            int minCoinChange = amount + 1;
            for (int i = 0; i < coins.length; i++) {
                if (restCoin - coins[i] >= 0) {
                    int tmpCoinChange = dp[restCoin - coins[i]];
                    if (tmpCoinChange != -1) {
                        minCoinChange = Math.min(minCoinChange, tmpCoinChange);
                    }
                }
            }

            if (minCoinChange == amount + 1) {
                dp[restCoin] = -1;
            } else {
                dp[restCoin] = minCoinChange + 1;
            }
        }

        return dp[amount];
    }

    /**
     * 从coins 中选择货币满足累加和满足rest 金额数的最小零钱数
     *
     * @param coins
     * @param rest
     * @return
     */
    int process(int[] coins, int amount, int rest) {
        if (rest == 0) {
            return 0;
        }

        if (rest < 0) {
            return -1;
        }

        int minCoinChange = amount + 1;
        for (int i = 0; i < coins.length; i++) {
            int tmpCoinChange = process(coins, amount, rest - coins[i]);
            if (tmpCoinChange != -1) {
                minCoinChange = Math.min(minCoinChange, tmpCoinChange);
            }
        }

        return minCoinChange + 1;
    }
}
