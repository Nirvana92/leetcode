package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/10/26 2:55 下午
 * @desc: 304. 二维区域和检索 - 矩阵不可变
 */
public class No_304_Two_dimensional_area_and_retrieval_matrix_immutable {

    class NumMatrix {
        // 定义每行的累加和. rowSum[i][j]: 标识 i 行, 0 ... j 的累加和
        int[][] rowSum = null;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int rowLen = matrix.length;
            int colLen = matrix[0].length;


            rowSum = new int[rowLen][colLen];
            // 初始化累加和
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    rowSum[i][j] = j == 0 ? matrix[i][j] : (rowSum[i][j - 1] + matrix[i][j]);
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            if (rowSum == null) {
                return sum;
            }

            for (int row = row1; row <= row2; row++) {
                for (int col = col1; col <= col2; col++) {
                    sum += col == 0 ? rowSum[row][col] : (rowSum[row][col] - rowSum[row][col - 1]);
                }
            }

            return sum;
        }
    }
}
