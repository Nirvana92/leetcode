package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No_1463_Cherry_Picking_II {
    @Test
    public void test() {
        int[][] grid = new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        int cherryPickup = cherryPickup(grid);
        System.out.println(cherryPickup);
    }

    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;

        Map<String, Integer> dps = new HashMap<>();

        return process(grid, rowLen, colLen, 0, 0, colLen - 1, dps);
    }

    int process(int[][] grid, int rowLen, int colLen, int row, int col1, int col2, Map<String, Integer> dps) {
        if (row == rowLen - 1) {
            return col1 == col2 ? grid[row][col1] : (grid[row][col1] + grid[row][col2]);
        }

        String key = row + "_" + col1 + "_" + col2;
        if (dps.containsKey(key)) {
            return dps.get(key);
        }

        int maxCherry = 0;
        // 左下左下
        if (col1 - 1 >= 0 && col2 - 1 >= 0) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1 - 1, col2 - 1, dps));
        }
        // 左下正下
        if (col1 - 1 >= 0) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1 - 1, col2, dps));
        }
        // 左下右下
        if (col1 - 1 >= 0 && col2 + 1 < colLen) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1 - 1, col2 + 1, dps));
        }
        // 正下左下
        if (col2 - 1 >= 0) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1, col2 - 1, dps));
        }
        // 正下正下
        maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1, col2, dps));
        // 正下右下
        if (col2 + 1 < colLen) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1, col2 + 1, dps));
        }
        // 右下左下
        if (col1 + 1 < colLen && col2 - 1 >= 0) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1 + 1, col2 - 1, dps));
        }
        // 右下正下
        if (col1 + 1 < colLen) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1 + 1, col2, dps));
        }
        // 右下右下
        if (col1 + 1 < colLen && col2 + 1 < colLen) {
            maxCherry = Math.max(maxCherry, process(grid, rowLen, colLen, row + 1, col1 + 1, col2 + 1, dps));
        }

        maxCherry = maxCherry + (col1 == col2 ? grid[row][col1] : (grid[row][col1] + grid[row][col2]));
        dps.put(key, maxCherry);
        return maxCherry;
    }
}
