package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2021/2/25 9:11 上午
 * @desc: 867. 转置矩阵
 */
public class No_867_Transpose_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};

        int[][] transpose = transpose(matrix);
        PrintUtils.print(transpose);
    }

    public int[][] transpose(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[][] transMatrix = new int[colLen][rowLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                transMatrix[col][row] = matrix[row][col];
            }
        }

        return transMatrix;
    }
}
