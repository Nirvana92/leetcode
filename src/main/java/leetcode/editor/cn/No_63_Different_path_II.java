package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/15 22:05
 * 63. 不同路径 II
 */
public class No_63_Different_path_II {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        grid = new int[][]{{0, 1}};
        grid = new int[][]{
                {0, 0},
                {1, 1},
                {0, 0}
        };
        int uniquePathsWithObstacles = uniquePathsWithObstacles(grid);
        System.out.println(uniquePathsWithObstacles);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length != 0 && obstacleGrid[0].length == 0) {
            return 1;
        }

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        // 暴利递归解
        //return process(obstacleGrid, row, col, 0, 0);

        // 动态规划解
        return processDP(obstacleGrid, row, col);
    }

    public int processDP(int[][] grid, int targetRow, int targetCol) {
        int[][] dp = new int[targetRow][targetCol];
        dp[targetRow - 1][targetCol - 1] = grid[targetRow - 1][targetCol - 1] == 1 ? 0 : 1;

        for (int row = targetRow - 1; row >= 0; row--) {
            if (grid[row][targetCol - 1] == 1) {
                break;
            }
            dp[row][targetCol - 1] = 1;
        }

        for (int col = targetCol - 1; col >= 0; col--) {
            if (grid[targetRow - 1][col] == 1) {
                break;
            }
            dp[targetRow - 1][col] = 1;
        }

        for (int row = targetRow - 2; row >= 0; row--) {
            for (int col = targetCol - 2; col >= 0; col--) {
                dp[row][col] += grid[row + 1][col] == 1 ? 0 : dp[row + 1][col];
                dp[row][col] += grid[row][col + 1] == 1 ? 0 : dp[row][col + 1];
            }
        }

        return dp[0][0];
    }

    public int process(int[][] grid, int targetRow, int targetCol, int row, int col) {
        if (row == targetRow - 1 && col == targetCol - 1) {
            return 1;
        }

        int rowMethod = 0;
        if (row < targetRow - 1 && grid[row + 1][col] != 1) {
            rowMethod = process(grid, targetRow, targetCol, row + 1, col);
        }

        int colMethod = 0;
        if (col < targetCol - 1 && grid[row][col + 1] != 1) {
            colMethod = process(grid, targetRow, targetCol, row, col + 1);
        }

        return rowMethod + colMethod;
    }

}
