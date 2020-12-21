package leetcode.editor.cn;

import org.junit.Test;

public class No_64_Minimum_path_sum {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int minPathSum = minPathSum(grid);
        System.out.println(minPathSum);
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] dp = new int[rowLen][colLen];

        return process(grid, 0, 0, dp);
    }

    /**
     * grid[startRow][startCol] 到 grid[endRow][endCol] 的自小路径和为多少返回
     * 沿途只能往左走或者往下走
     *
     * @param grid
     * @param startRow
     * @param startCol
     * @return
     */
    int process(int[][] grid, int startRow, int startCol, int[][] dp) {
        int endRow = grid.length;
        int endCol = grid[0].length;

        if (startRow > (endRow - 1) || startCol > (endCol - 1)) {
            return 0;
        }

        // 到达的结束的位置
        if (startRow == (endRow - 1) && startCol == (endCol - 1)) {
            return grid[endRow - 1][endCol - 1];
        }

        if (dp[startRow][startCol] != 0) {
            return dp[startRow][startCol];
        }

        // 比较向下的位置和向右的位置的路径和的最小值
        int rightPathSum = Integer.MAX_VALUE, downPathSum = Integer.MAX_VALUE;

        if (startCol < (endCol - 1)) {
            rightPathSum = process(grid, startRow, startCol + 1, dp);
        }

        if (startRow < (endRow - 1)) {
            downPathSum = process(grid, startRow + 1, startCol, dp);
        }

        int pathSum = grid[startRow][startCol] + Math.min(rightPathSum, downPathSum);
        dp[startRow][startCol] = pathSum;

        return pathSum;
    }
}
