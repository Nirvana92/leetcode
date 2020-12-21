package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

public class No_59_Spiral_Matrix_II {
    @Test
    public void test() {
        int n = 0;
        int[][] generateMatrix = generateMatrix(n);
        PrintUtils.print(generateMatrix);
    }

    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }

        int[][] matrix = new int[n][n];

        int startRow = 0, startCol = 0;
        int endRow = n - 1, endCol = n - 1;
        int curNum = 1;
        while (startRow <= endRow && startCol <= endCol) {
            curNum = process(matrix, startRow, startCol, endRow, endCol, curNum);

            startRow += 1;
            startCol += 1;
            endRow -= 1;
            endCol -= 1;
        }

        return matrix;
    }

    int process(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int curNum) {
        for (int col = startCol; col <= endCol; col++) {
            matrix[startRow][col] = curNum++;
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            matrix[row][endCol] = curNum++;
        }

        for (int col = endCol - 1; col >= startCol && startRow != endRow; col--) {
            matrix[endRow][col] = curNum++;
        }

        for (int row = endRow - 1; row > startRow && startCol != endCol; row--) {
            matrix[row][startCol] = curNum++;
        }

        return curNum;
    }
}
