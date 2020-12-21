package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/15 22:38
 * <p>
 * 688. “马”在棋盘上的概率
 */
public class No_688_Probability_of_horse_on_the_chessboard {
    @Test
    public void test() {
        int N = 3, K = 2, r = 0, c = 0;
        N = 25;
        K = 100;
        r = 12;
        c = 12;
        double knightProbability = knightProbability(N, K, r, c);
        System.out.println(knightProbability);
    }

    /**
     * N*N 的棋盘, 需要走K步, 马走日. 当前处于(r,c)位置, 问K步之后还留在棋盘上的概率
     *
     * @param N
     * @param K
     * @param r
     * @param c
     * @return
     */
    public double knightProbability(int N, int K, int r, int c) {
        // 总的可行走的钟数
        // double sumKinds = Math.pow(8, K);

        // 暴利递归方法
        // int process = process(N, K, r, c);
        // 改写动态规划方法
        // int process = processDp(N, K, r, c);

//        double v = new BigDecimal(process).divide(new BigDecimal(sumKinds)).doubleValue();
//        System.out.println(v);
        // return process / sumKinds;
        return processDp(N, K, r, c);
    }

    double processDp(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int i = 1; i <= K; i++) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    dp[row][col][i] += ((row - 2 >= 0 && row - 2 < N && col - 1 >= 0 && col - 1 < N) ? dp[row - 2][col - 1][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row - 1 >= 0 && row - 1 < N && col - 2 >= 0 && col - 2 < N) ? dp[row - 1][col - 2][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row + 1 >= 0 && row + 1 < N && col + 2 >= 0 && col + 2 < N) ? dp[row + 1][col + 2][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row + 2 >= 0 && row + 2 < N && col + 1 >= 0 && col + 1 < N) ? dp[row + 2][col + 1][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row + 1 >= 0 && row + 1 < N && col - 2 >= 0 && col - 2 < N) ? dp[row + 1][col - 2][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row + 2 >= 0 && row + 2 < N && col - 1 >= 0 && col - 1 < N) ? dp[row + 2][col - 1][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row - 2 >= 0 && row - 2 < N && col + 1 >= 0 && col + 1 < N) ? dp[row - 2][col + 1][i - 1] : 0) / 8.0;
                    dp[row][col][i] += ((row - 1 >= 0 && row - 1 < N && col + 2 >= 0 && col + 2 < N) ? dp[row - 1][col + 2][i - 1] : 0) / 8.0;

                    // dp[row][col][i] /= 8.0;
                }
            }
        }

        return dp[r][c][K];
    }

    int process(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }

        if (K == 0) {
            return 1;
        }

        int p1 = process(N, K - 1, r - 2, c - 1);
        int p2 = process(N, K - 1, r - 1, c - 2);
        int p3 = process(N, K - 1, r + 1, c + 2);
        int p4 = process(N, K - 1, r + 2, c + 1);

        int p5 = process(N, K - 1, r + 1, c - 2);
        int p6 = process(N, K - 1, r + 2, c - 1);
        int p7 = process(N, K - 1, r - 2, c + 1);
        int p8 = process(N, K - 1, r - 1, c + 2);

        return p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
    }
}
