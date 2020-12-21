package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/30 9:37 上午
 * @desc: 463. 岛屿的周长
 */
public class No_463_Perimeter_of_the_island {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        int islandPerimeter = islandPerimeter(grid);
        System.out.println(islandPerimeter);
    }

    /**
     * 遍历每个1 的位置, 查看周边有多少个0, 就有多少个边
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int sumPerimeters = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                sumPerimeters += process(grid, row, col);
            }
        }

        return sumPerimeters;
    }

    /**
     * @param grid: 地图
     * @param row:  开始遍历的行号
     * @param col:  开始遍历的列号
     * @return
     */
    int process(int[][] grid, int row, int col) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (grid[row][col] == 0 || grid[row][col] == -1) {
            return 0;
        }

        int tmpPerimeters = 0;
        // tmpPerimeters += (row + 1 < rowLen && grid[row + 1][col] == 1) ? process(grid, row + 1, col) : 1;
        grid[row][col] = -1;
        if (row + 1 < rowLen) {
            if (grid[row + 1][col] == 1) {
                tmpPerimeters += process(grid, row + 1, col);
            } else if (grid[row + 1][col] != -1) {
                tmpPerimeters++;
            }
        } else {
            tmpPerimeters++;
        }


        // tmpPerimeters += (row - 1 >= 0 && grid[row - 1][col] == 1) ? process(grid, row - 1, col) : 1;
        if (row - 1 >= 0) {
            if (grid[row - 1][col] == 1) {
                tmpPerimeters += process(grid, row - 1, col);
            } else if (grid[row - 1][col] != -1) {
                tmpPerimeters++;
            }
        } else {
            tmpPerimeters++;
        }

        // tmpPerimeters += (col + 1 < colLen && grid[row][col + 1] == 1) ? process(grid, row, col + 1) : 1;

        if (col + 1 < colLen) {
            if (grid[row][col + 1] == 1) {
                tmpPerimeters += process(grid, row, col + 1);
            } else if (grid[row][col + 1] != -1) {
                tmpPerimeters++;
            }
        } else {
            tmpPerimeters++;
        }

        // tmpPerimeters += (col - 1 >= 0 && grid[row][col - 1] == 1) ? process(grid, row, col - 1) : 1;

        if (col - 1 >= 0) {
            if (grid[row][col - 1] == 1) {
                tmpPerimeters += process(grid, row, col - 1);
            } else if (grid[row][col - 1] != -1) {
                tmpPerimeters++;
            }
        } else {
            tmpPerimeters++;
        }

        return tmpPerimeters;
    }
}
