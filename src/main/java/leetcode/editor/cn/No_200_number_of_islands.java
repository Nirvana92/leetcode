package leetcode.editor.cn;

public class No_200_number_of_islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int numOfIslands = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == '1') {
                    numOfIslands++;
                    grid[row][col] = '2';

                    process(row - 1, col, grid);
                    process(row + 1, col, grid);
                    process(row, col - 1, grid);
                    process(row, col + 1, grid);
                }
            }
        }

        return numOfIslands;
    }

    void process(int row, int col, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (row >= 0 && row < rowLen && col >= 0 && col < colLen && grid[row][col] == '1') {
            grid[row][col] = '2';

            process(row - 1, col, grid);
            process(row + 1, col, grid);
            process(row, col - 1, grid);
            process(row, col + 1, grid);
        }
    }
}
