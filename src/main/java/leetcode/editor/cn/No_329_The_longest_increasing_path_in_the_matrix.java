package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/9 5:46 下午
 * @desc: 矩阵中的最长递增路径
 */
public class No_329_The_longest_increasing_path_in_the_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        matrix = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };

        int longestIncreasingPath = longestIncreasingPath(matrix);
        System.out.println(longestIncreasingPath);
    }

    /**
     * 该方法执行提示超出时间限制
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[][] dp = new int[rowLen][colLen];

        int maxLen = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                maxLen = Math.max(process(matrix, row, col, dp), maxLen);
            }
        }

        return maxLen;
    }

    /**
     * 不需要考虑路径回退问题, 因为是递增子序列, 所以默认是不会走回头路的
     *
     * @param matrix
     * @param row
     * @param col
     * @param dp
     * @return
     */
    int process(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        // 左边
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxLen = 0;
        if (col - 1 >= 0 && matrix[row][col] < matrix[row][col - 1]) {
            maxLen = Math.max(maxLen, process(matrix, row, col - 1, dp));
        }
        // 右边
        if (col + 1 < colLen && matrix[row][col] < matrix[row][col + 1]) {
            maxLen = Math.max(maxLen, process(matrix, row, col + 1, dp));
        }
        // 上边
        if (row - 1 >= 0 && matrix[row][col] < matrix[row - 1][col]) {
            maxLen = Math.max(maxLen, process(matrix, row - 1, col, dp));
        }
        // 下边
        if (row + 1 < rowLen && matrix[row][col] < matrix[row + 1][col]) {
            maxLen = Math.max(maxLen, process(matrix, row + 1, col, dp));
        }

        dp[row][col] = maxLen + 1;
        return maxLen + 1;
    }
}
