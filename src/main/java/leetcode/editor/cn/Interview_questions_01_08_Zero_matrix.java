package leetcode.editor.cn;

import org.junit.Test;

/**
 * 零矩阵
 */
public class Interview_questions_01_08_Zero_matrix {
    @Test
    public void test() {

    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // 遍历二位数组, 碰到0 , 将该位置所对应的 0行, 0列 上的数字置为0, 然后再次遍历, 修改为0 的行和列的数值
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        boolean markFirstZero = matrix[0][0] == 0;
        boolean resetZeroRowToZero = false;
        boolean resetZeroColToZero = false;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if ((row != 0 || col != 0) && matrix[row][col] == 0) {
                    if (row == 0) {
                        resetZeroRowToZero = true;
                    }
                    if (col == 0) {
                        resetZeroColToZero = true;
                    }
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        // 再次遍历, 将行列为0 的值的行列置为0
        for (int row = 1; row < rowLen; row++) {
            if (matrix[row][0] == 0) {
                // 将 row 行全部置为0
                resetRowZero(matrix, row);
            }
        }

        for (int col = 1; col < colLen; col++) {
            if (matrix[0][col] == 0) {
                resetColZero(matrix, col);
            }
        }

        if (markFirstZero) {
            resetRowZero(matrix, 0);
            resetColZero(matrix, 0);
        }
        if (!markFirstZero && resetZeroRowToZero) {
            resetRowZero(matrix, 0);
        }
        if (!markFirstZero && resetZeroColToZero) {
            resetColZero(matrix, 0);
        }
    }

    /**
     * 将row 这一行的数值都置为 0
     *
     * @param matrix
     * @param row
     */
    void resetRowZero(int[][] matrix, int row) {
        int colLen = matrix[0].length;
        for (int col = 0; col < colLen; col++) {
            matrix[row][col] = 0;
        }
    }

    /**
     * 将col 这一列的数值都置为 0
     *
     * @param matrix
     * @param col
     */
    void resetColZero(int[][] matrix, int col) {
        int rowLen = matrix.length;
        for (int row = 0; row < rowLen; row++) {
            matrix[row][col] = 0;
        }
    }
}
