package lintcode;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/14 7:04 下午
 * @desc: 92. 背包问题
 */
public class No_92_backpack {
    @Test
    public void test() {
        int m = 10;
        int[] a = new int[]{3, 4, 8, 5};

        m = 12;
        a = new int[]{2, 3, 5, 7};

        int backPack = backPack(m, a);
        System.out.println(backPack);

        int dp = dp(m, a);
        System.out.println(dp);

        int dpOpti = dpOpti(m, a);
        System.out.println(dpOpti);
    }

    public int dpOpti(int m, int[] a) {
        int len = a.length;
        int[] dp = new int[m + 1];
        int[] preDp = new int[m + 1];
        int[] tmp = null;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= m; j++) {
                // dp[i][j] = dp[i + 1][j];
                dp[j] = preDp[j];

                if (a[i] <= j) {
                    // 选择当前的物品
                    // int p2 = dp[i + 1][j - a[i]];
                    // int p2 = preDp[j - a[i]];

                    dp[j] = Math.max(dp[j], preDp[j - a[i]] + a[i]);
                }
            }

            // 交换两个dp
            // swap(dp, preDp);
            tmp = dp;
            dp = preDp;
            preDp = tmp;
        }

        return preDp[m];
    }

    public int dp(int m, int[] a) {
        int len = a.length;
        int[][] dp = new int[len + 1][m + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int remindM = 0; remindM <= m; remindM++) {
                dp[i][remindM] = dp[i + 1][remindM];

                if (a[i] <= remindM) {
                    // 选择当前的物品
                    int p2 = dp[i + 1][remindM - a[i]];

                    dp[i][remindM] = Math.max(dp[i][remindM], p2 + a[i]);
                }
            }
        }

        return dp[0][m];
    }

    public int backPack(int m, int[] A) {
        // write your code here
        // int[] dp = new int[A.length];
        return process(A, 0, m);
    }

    int process(int[] a, int i, int remindM) {
        if (i == a.length) {
            return 0;
        }

        // 不选择当前的物品
        int result = process(a, i + 1, remindM);
        if (a[i] <= remindM) {
            // 选择当前的物品
            int p2 = process(a, i + 1, remindM - a[i]);

            result = Math.max(result, p2 + a[i]);
        }

        return result;
    }
}
