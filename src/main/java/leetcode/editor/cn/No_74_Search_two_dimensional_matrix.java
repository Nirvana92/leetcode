package leetcode.editor.cn;

import org.junit.Test;

public class No_74_Search_two_dimensional_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        matrix = new int[][]{};
        int target = 13;
        boolean searchMatrix = searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }

    // todo: 时间复杂度可以通过 logM * logN . 二分法查找
    // 从左下角开始由下往上找
    // 找到第一次 target 大于的地方, 然后在当前行从左往右找, 找到返回true, 找不到返回false
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // 在第一列找到第一次target 大于的地方
        int curRow = -1;
        for (int row = rowLen - 1; row >= 0; row--) {
            if (matrix[row][0] <= target) {
                curRow = row;
                break;
            }
        }
        if (curRow == -1) {
            return false;
        }

        for (int col = 0; col < colLen; col++) {
            if (matrix[curRow][col] == target) {
                return true;
            } else if (target < matrix[curRow][col]) {
                return false;
            }
        }

        return false;
    }
}
