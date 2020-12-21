package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * 130. 被围绕的区域
 * <p>
 * 思路: 遍历区域的边界地区, 碰到 O 找该位置的上下左右位置, 将连续的 O 设置为 o.
 * 然后遍历的时候除了 o 其他都是X
 */
public class No_130_surrounded_area {

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        board = new char[][]{{'X', 'X', 'X', 'O'}};
        board = new char[][]{{'O'}, {'X'}, {'X'}};
        solve(board);

        PrintUtils.print(board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rowLen = board.length;
        int colLen = board[0].length;

        boolean[][] checked = new boolean[rowLen][colLen];
        for (int col = 0; col < colLen; col++) {
            // 处理 0 行
            if (board[0][col] == 'O') {
                // 将board[0][col] = p
                board[0][col] = 'P';
                checked[0][col] = true;
                process(1, col, checked, board);
//                process(0, col - 1, checked, board);
//                process(0, col + 1, checked, board);
            }

            // 处理rowLen -1 行
            if (board[rowLen - 1][col] == 'O') {
                board[rowLen - 1][col] = 'P';
                checked[rowLen - 1][col] = true;
                process(rowLen - 2, col, checked, board);
//                process(rowLen - 1, col - 1, checked, board);
//                process(rowLen - 1, col + 1, checked, board);
            }
        }

        for (int row = 0; row < rowLen; row++) {
            // 处理 0列
            if (board[row][0] == 'O') {
                board[row][0] = 'P';
                checked[row][0] = true;
                process(row, 1, checked, board);
//                process(row - 1, 0, checked, board);
//                process(row + 1, 0, checked, board);
            }

            // 处理 colLen -1 列
            if (board[row][colLen - 1] == 'O') {
                board[row][colLen - 1] = 'P';
                checked[row][colLen - 1] = true;
                process(row, colLen - 2, checked, board);
//                process(row - 1, colLen - 1, checked, board);
//                process(row + 1, colLen - 1, checked, board);
            }
        }

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == 'P') {
                    board[row][col] = 'O';
                } else {
                    board[row][col] = 'X';
                }
            }
        }
    }

    void process(int row, int col, boolean[][] checked, char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        if (row >= 0 && row < rowLen && col >= 0 && col < colLen && !checked[row][col] && board[row][col] == 'O') {
            board[row][col] = 'P';
            checked[row][col] = true;
            process(row - 1, col, checked, board);
            process(row + 1, col, checked, board);
            process(row, col - 1, checked, board);
            process(row, col + 1, checked, board);
        }
    }
}
