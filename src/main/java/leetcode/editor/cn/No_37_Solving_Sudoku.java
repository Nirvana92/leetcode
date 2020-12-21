package leetcode.editor.cn;

//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
// 空白格用 '.' 表示。
//
// 一个数独。
//
// 答案被标成红色。
//
// Note: 
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 491 👎 0

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * todo: 给定一个棋盘, 解析得到结果
 */
public class No_37_Solving_Sudoku {
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
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        PrintUtils.print(board);
    }

    public void solveSudoku(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        // 一维表示第几行, 二维内容表示 数字 1-9[需要-1], 整体表示是否已经存在, true false
        boolean[][] rowHaveVals = new boolean[rowLen][colLen];
        // 一维表示第几列
        boolean[][] colHaveVals = new boolean[rowLen][colLen];
        // 一维表示 3*3小方格
        boolean[][] smallCubeHaveVals = new boolean[rowLen][colLen];

        List<Point> blankInfos = new ArrayList<>();
        int curNum = 0, smallCubeIndex = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == '.') {
                    // 收集空白格的行列坐标
                    blankInfos.add(new Point(row, col));
                    continue;
                }

                curNum = board[row][col] - '1';

                smallCubeIndex = row / 3 * 3 + col / 3;

                // 将当前位置的内容添加到 rowHaveVals colHaveVals smallCubeHaveVals 中
                rowHaveVals[row][curNum] = true;
                colHaveVals[col][curNum] = true;
                smallCubeHaveVals[smallCubeIndex][curNum] = true;
            }
        }


        process(board, 0, rowHaveVals, colHaveVals, smallCubeHaveVals, blankInfos);
    }

    boolean process(char[][] board, int startIndex, boolean[][] rowHaveVals, boolean[][] colHaveVals, boolean[][] smallCubeHaveVals, List<Point> points) {
        if (startIndex == points.size()) {
            return true;
        }

        int row = points.get(startIndex).row;
        int col = points.get(startIndex).col;

        for (int i = 0; i < 9; i++) {
            int curNum = i;
            int smallCubeIndex = row / 3 * 3 + col / 3;
            if (!rowHaveVals[row][curNum] && !colHaveVals[col][curNum] && !smallCubeHaveVals[smallCubeIndex][curNum]) {
                board[row][col] = (char) (curNum + '1');
                // 填充已经填充的数字的值
                rowHaveVals[row][curNum] = true;
                colHaveVals[col][curNum] = true;
                smallCubeHaveVals[smallCubeIndex][curNum] = true;

                boolean rst = process(board, startIndex + 1, rowHaveVals, colHaveVals, smallCubeHaveVals, points);
                if (rst) {
                    return rst;
                }
                board[row][col] = '.';
                rowHaveVals[row][curNum] = false;
                colHaveVals[col][curNum] = false;
                smallCubeHaveVals[smallCubeIndex][curNum] = false;
            }
        }
        return false;
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}