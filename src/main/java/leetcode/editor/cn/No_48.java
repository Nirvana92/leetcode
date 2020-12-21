package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 48. 旋转图像
 */
public class No_48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        No_48 no_48 = new No_48();
        no_48.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void rotate(int[][] matrix) {
        int startRow = 0, startCol = 0,
            endRow = matrix.length-1, endCol = matrix[0].length-1;

        while (startRow < endRow) {
            spin(matrix, startRow, startCol, endRow, endCol, endRow - startRow);

            startRow ++;
            startCol ++;
            endRow --;
            endCol --;
        }
    }

    public void spin(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int k) {
        for (int i = 0; i < k; i++) {
            // 更换四个元素的位置
            // matrix[startRow][startCol+i]
            // matrix[startRow+1][endCol]
            // matrix[endRow][endCol-i]
            // matrix[endRow-i][startCol]
            int tmp = matrix[startRow][startCol+i];
            matrix[startRow][startCol+i] = matrix[endRow-i][startCol];
            matrix[endRow-i][startCol] = matrix[endRow][endCol-i];
            matrix[endRow][endCol-i] = matrix[startRow+i][endCol];
            matrix[startRow+i][endCol] = tmp;
        }
    }
}
