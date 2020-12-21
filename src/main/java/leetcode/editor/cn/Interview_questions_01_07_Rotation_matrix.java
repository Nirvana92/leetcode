package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * 旋转矩阵
 */
public class Interview_questions_01_07_Rotation_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);

        PrintUtils.print(matrix);
    }

    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int len = matrix.length;

        int startIndex = 0, endIndex = len - 1;

        while (startIndex < endIndex) {
            rotate(matrix, startIndex, endIndex);

            startIndex++;
            endIndex--;
        }
    }

    /**
     * 因为是N*N 每次移动的位置其实 row == col
     *
     * @param matrix
     * @param startIndex
     * @param endIndex
     */
    void rotate(int[][] matrix, int startIndex, int endIndex) {
        for (int i = 0; i < (endIndex - startIndex); i++) {
            int tmpVal = matrix[startIndex][startIndex + i];
            // 左上角的点赋值
            matrix[startIndex][startIndex + i] = matrix[endIndex - i][startIndex];
            // 左下角的点赋值
            matrix[endIndex - i][startIndex] = matrix[endIndex][endIndex - i];
            // 右下角的点赋值
            matrix[endIndex][endIndex - i] = matrix[startIndex + i][endIndex];
            // 右上角的点赋值
            matrix[startIndex + i][endIndex] = tmpVal;
        }
    }
}
