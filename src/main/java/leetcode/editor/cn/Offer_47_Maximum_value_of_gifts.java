package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/21 23:05
 * <p>
 * 剑指 Offer 47. 礼物的最大价值
 */
public class Offer_47_Maximum_value_of_gifts {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int maxValue = maxValue(grid);
        System.out.println(maxValue);
    }

    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int[][] dp = new int[rowLen][colLen];
        dp[rowLen - 1][colLen - 1] = grid[rowLen - 1][colLen - 1];

        for (int row = rowLen - 2; row >= 0; row--) {
            dp[row][colLen - 1] = dp[row + 1][colLen - 1] + grid[row][colLen - 1];
        }

        for (int col = colLen - 2; col >= 0; col--) {
            dp[rowLen - 1][col] = dp[rowLen - 1][col + 1] + grid[rowLen - 1][col];
        }

        for (int row = rowLen - 2; row >= 0; row--) {
            for (int col = colLen - 2; col >= 0; col--) {
                dp[row][col] = grid[row][col] + Math.max(dp[row + 1][col], dp[row][col + 1]);
            }
        }

        return dp[0][0];
    }
}
