package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/26 3:28 下午
 * @desc: 419. 甲板上的战舰
 */
public class No_419_Battleship_on_deck {
    @Test
    public void test() {
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        board = new char[][]{
                {'.', '.', '.', 'X'},
                {'X', 'X', 'X', 'X'},
                {'.', '.', '.', 'X'}
        };

        int countBattleships = countBattleships(board);
        System.out.println(countBattleships);
    }

    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int rowLen = board.length;
        int colLen = board[0].length;

        int battles = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                // 'X' 标记
                // 判断上下左右 是否同时存在 'X'

                boolean sameRow = false;
                boolean sameCol = false;
                boolean needAdd = true;
                if (row - 1 >= 0 && board[row - 1][col] == 'X') {
                    // 上
                    sameRow = true;
                    needAdd = false;
                }

                if (row + 1 < rowLen && board[row + 1][col] == 'X') {
                    // 下
                    sameRow = true;
                }

                if (col - 1 >= 0 && board[row][col - 1] == 'X') {
                    // 左
                    sameCol = true;
                    needAdd = false;
                }

                if (col + 1 < colLen && board[row][col + 1] == 'X') {
                    // 右
                    sameCol = true;
                }

                if (sameRow && sameCol) {
                    // 不合理的给定数据
                    return -1;
                }

                if (needAdd) {
                    battles++;
                }
            }
        }

        return battles;
    }
}
