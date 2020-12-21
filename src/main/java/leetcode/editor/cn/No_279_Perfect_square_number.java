package leetcode.editor.cn;

import org.junit.Test;

public class No_279_Perfect_square_number {
    @Test
    public void test() {
        int n = 45648768;
        n = 13;
        int numSquares = numSquares(n);
        System.out.println(numSquares);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    /**
     * 暴利方法: 这个最终还是会超出时间限制
     *
     * @param n
     * @return
     */
    public int numProfiteeringMethod(int n) {
        int numOfSquares = n;

        if (n <= 0) {
            return 0;
        }

        int sqrt = (int) Math.sqrt(n);
        if (Math.pow(sqrt, 2) == n) {
            return 1;
        }

        for (int i = sqrt; i >= 1; i--) {
            n -= Math.pow(i, 2);
            int tmpNumOfSquares = numSquares(n) + 1;
            n += Math.pow(i, 2);

            numOfSquares = Math.min(numOfSquares, tmpNumOfSquares);
        }
        return numOfSquares;
    }
}
