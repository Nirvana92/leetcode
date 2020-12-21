package leetcode.editor.cn;

import org.junit.Test;

public class No_240_Search_2D_Matrix_II {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 20;
        boolean searchMatrix = searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int row = rowLen - 1, col = 0;

        while (row >= 0 && row < rowLen && col >= 0 && col < colLen) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }
}
