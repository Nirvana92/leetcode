package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/11 6:24 下午
 * @desc: 629. K个逆序对数组
 */
public class No_629_K_arrays_of_reversed_pairs {
    @Test
    public void test() {
        int n = 10, k = 3;
//        n = 3;
//        k = 3;
        n = 1000;
        k = 1000;

//        int kInversePairs = kInversePairs(n, k);
//        System.out.println(kInversePairs);
//
//        int dp = dp(n, k);
//        System.out.println(dp);

        int dpOpti = dpOpti(n, k);
        System.out.println(dpOpti);
    }

    /**
     * 摸底第n 个数字放置的位置, 依次考虑各种情况, 然后总结每种情况. 求得最终的结果
     *
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        return process(n, k);
    }

    int process(int n, int k) {
        if (k == 0) {
            return 1;
        }

        if (n == 1) {
            return 0;
        }

        int ret = 0;
        // 当前最多处理 n-1 个逆序对. 所以剩下的逆序对.
        for (int i = Math.max(0, k - n + 1); i <= k && i <= (n * (n - 1) / 2); i++) {
            ret += process(n - 1, i);
        }

        return ret;
    }

    /**
     * dp[i][j] = dp[i-1][k] + dp[i-1][k-1] + ... dp[i-1][j-i+1]
     *
     * @param n
     * @param k
     * @return
     */
    int dp(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int ret = 0;
                    for (int curK = Math.max(0, j - i + 1); curK <= j && curK <= (i * (i - 1) / 2); curK++) {
                        ret += dp[i - 1][curK];
                    }
                    dp[i][j] = ret;
                }
            }
        }

        return dp[n][k];
    }

    int dpOpti(int n, int k) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k && j <= (i * (i - 1) / 2); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    long val = (dp[i - 1][j] + MOD - (j - i >= 0 ? dp[i - 1][j - i] : 0)) % MOD;
                    dp[i][j] = (int) ((dp[i][j - 1] + val) % MOD);
                }
            }
        }

        return dp[n][k];
    }
}
