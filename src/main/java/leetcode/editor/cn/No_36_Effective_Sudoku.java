package leetcode.editor.cn;

import org.junit.Test;

public class No_36_Effective_Sudoku {
    @Test
    public void test() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        // 一维表示第几行, 二维内容表示 数字 1-9[需要-1], 整体表示是否已经存在, true false
        boolean[][] rowHaveVals = new boolean[rowLen][colLen];
        // 一维表示第几列
        boolean[][] colHaveVals = new boolean[rowLen][colLen];
        // 一维表示 3*3小方格
        boolean[][] smallCubeHaveVals = new boolean[rowLen][colLen];

        int curNum = 0, smallCubeIndex = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                curNum = board[row][col] - '1';

                smallCubeIndex = row / 3 * 3 + col / 3;
                if (rowHaveVals[row][curNum] || colHaveVals[col][curNum] || smallCubeHaveVals[smallCubeIndex][curNum]) {
                    return false;
                }

                // 将当前位置的内容添加到 rowHaveVals colHaveVals smallCubeHaveVals 中
                rowHaveVals[row][curNum] = true;
                colHaveVals[col][curNum] = true;
                smallCubeHaveVals[smallCubeIndex][curNum] = true;
            }
        }

        return true;
    }
}
