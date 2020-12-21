package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/12 1:48 下午
 * @desc: 1643. 第 K 条最小指令
 * <p>
 * 排列取值求第几个的例题
 */
public class No_1643_Kth_minimum_instruction {
    @Test
    public void test() {
        int[] destination = new int[]{2, 3};
        int k = 3;
        String kthSmallestPath = kthSmallestPath(destination, k);
        System.out.println(kthSmallestPath);
    }

    public String kthSmallestPath(int[] destination, int k) {
        StringBuffer buffer = new StringBuffer();
        int hNums = destination[1];
        int vNums = destination[0];

        int totalNums = hNums + vNums;
        int[][] dp = comDp(totalNums, hNums);

        while (hNums > 0 && vNums > 0) {
            int curComNums = dp[hNums + vNums - 1][hNums - 1];
            if (curComNums >= k) {
                buffer.append('H');
                hNums--;
            } else {
                buffer.append('V');
                k -= curComNums;
                vNums--;
            }
        }

        if (hNums == 0) {
            for (int i = 0; i < vNums; i++) {
                buffer.append('V');
            }
        } else {
            for (int i = 0; i < hNums; i++) {
                buffer.append('H');
            }
        }

        return buffer.toString();
    }

    /**
     * 查询统计数
     *
     * @param n
     * @param m
     * @return
     */
    int[][] comDp(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            if (i <= m) {
                dp[i][i] = 1;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        return dp;
    }

    @Test
    public void t() {
//        int n = 10, m = 2;
//        int comDp = comDp(n, m);
//        int com = com(n, m);
//
//        System.out.println("comDp: " + comDp);
//        System.out.println("com: " + com);
//
//        if (comDp != com) {
//            System.out.println("comDp: " + comDp);
//            System.out.println("com: " + com);
//            System.out.println("error");
//        }
    }

//    int comDp(int n, int m) {
//        int[][] dp = new int[n + 1][m + 1];
//
//        for (int i = 0; i < n; i++) {
//            if (i <= m) {
//                dp[i][i] = 1;
//            }
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i && j <= m; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
//            }
//        }
//
//        return dp[n][m];
//    }

    int com(int n, int m) {
        if (m == 0 || m == n) {
            return 1;
        }

        return com(n - 1, m) + com(n - 1, m - 1);
    }
}
