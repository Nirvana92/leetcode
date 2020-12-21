package leetcode.editor.cn;

import org.junit.Test;

import java.util.Random;

public class No_62_Different_path {
    public static void main(String[] args) {
        No_62_Different_path no_62 = new No_62_Different_path();
        int m = 7, n = 3;
        int uniquePath = no_62.uniquePaths(m, n);
        System.out.println(uniquePath);
    }

    @Test
    public void test() {
        int maxVal = 10;
        Random random = new Random();
        int times = 1000000;

        for (int i = times; i > 0; i--) {
            int m = random.nextInt(maxVal) + 1;
            int n = random.nextInt(maxVal) + 1;

            int umiquePaths = uniquePaths(m, n);
            int dpResult = processDP(m, n);
            if (umiquePaths != dpResult) {
                System.out.println("m: " + m + "; n: " + n);
                System.out.println("umiquePaths: " + umiquePaths + "; dpResult: " + dpResult);
            }
        }
    }

    public int uniquePaths(int m, int n) {
        return process(m, n, 0, 0);
    }

    public int processDP(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;

        for (int row = m - 1; row >= 0; row--) {
            dp[row][n - 1] = 1;
        }

        for (int col = n - 1; col >= 0; col--) {
            dp[m - 1][col] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }

        return dp[0][0];
    }

    public int process(int m, int n, int row, int col) {
        if (row == n - 1 && col == m - 1) {
            return 1;
        }

        int rowMethod = 0;
        if (row < n - 1) {
            rowMethod = process(m, n, row + 1, col);
        }

        int colMethod = 0;
        if (col < m - 1) {
            colMethod = process(m, n, row, col + 1);
        }

        return rowMethod + colMethod;
    }
}
