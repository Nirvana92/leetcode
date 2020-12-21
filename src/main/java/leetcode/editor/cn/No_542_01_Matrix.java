package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/11/3 5:42 下午
 * @desc: 542. 01 矩阵
 * 动态规划
 * bfs
 */
public class No_542_01_Matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };

        matrix = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        matrix = new int[][]{
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 1, 1}
        };

        int[][] updateMatrix = updateMatrix(matrix);
        PrintUtils.print(updateMatrix);
    }

    /**
     * bfs 可以处理. 将每个0 将入到队列中，一次弹出。然后将为1 的加入到队列中。一次弹出。最后全部统计完成结束。
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[][]{};
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] dp = new int[rowLen][colLen];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                dp[row][col] = matrix[row][col] == 0 ? 0 : 10000;
            }
        }

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (row - 1 >= 0) {
                    dp[row][col] = Math.min(dp[row][col], dp[row - 1][col] + 1);
                }

                if (col - 1 >= 0) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][col - 1] + 1);
                }
            }
        }

        for (int row = rowLen - 1; row >= 0; row--) {
            for (int col = colLen - 1; col >= 0; col--) {
                if (row + 1 < rowLen) {
                    dp[row][col] = Math.min(dp[row][col], dp[row + 1][col] + 1);
                }

                if (col + 1 < colLen) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][col + 1] + 1);
                }
            }
        }

        return dp;
    }
}
