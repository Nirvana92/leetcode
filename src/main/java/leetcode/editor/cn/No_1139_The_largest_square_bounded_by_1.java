package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/19 3:27 下午
 * @desc: 1139. 最大的以 1 为边界的正方形
 */
public class No_1139_The_largest_square_bounded_by_1 {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        grid = new int[][]{
                {1, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };

        int largest1BorderedSquare = largest1BorderedSquare(grid);
        System.out.println(largest1BorderedSquare);
    }

    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        // 统计每个点从上到下的的累加和
        int[][] leftSums = new int[rowLen][colLen];
        int[][] upSums = new int[rowLen][colLen];

        // 初始化累加和数组
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                // 计算 leftSums
                if (col == 0) {
                    leftSums[row][col] = grid[row][col];
                } else {
                    leftSums[row][col] = grid[row][col] == 1 ? leftSums[row][col - 1] + 1 : 0;
                }
                // 计算 upSums
                if (row == 0) {
                    upSums[row][col] = grid[row][col];
                } else {
                    upSums[row][col] = grid[row][col] == 1 ? upSums[row - 1][col] + 1 : 0;
                }
            }
        }

        // 遍历每个节点, 找到最大的边长
        int maxSideLen = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                // 最大边长
                int maxSide = Math.min(leftSums[row][col], upSums[row][col]);
                // 遍历边长找到最大的值
                for (int side = maxSide; side > 0; side--) {
                    // 遍历边长
                    // 左下角点
//                    int r1 = row;
//                    int c1 = col - side + 1;

                    // 右上角点
//                    int r2 = row - side + 1;
//                    int c2 = col;
                    if (upSums[row][col - side + 1] >= side && leftSums[row - side + 1][col] >= side) {
                        // 满足条件就下最大的边长值
                        maxSideLen = Math.max(maxSideLen, side);
                    }
                }
            }
        }

        return maxSideLen * maxSideLen;
    }
}
