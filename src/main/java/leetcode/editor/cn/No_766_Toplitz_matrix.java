package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/2/22 9:36 上午
 * @desc: 766. 托普利茨矩阵
 */
public class No_766_Toplitz_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        matrix = new int[][]{{1, 2}, {2, 2}};

        boolean toeplitzMatrix = isToeplitzMatrix(matrix);
        System.out.println(toeplitzMatrix);
    }

    /**
     * 遍历每个元素, 然后找到每个元素的右上角的位置, 然后进行判断, 如果不相同则返回false
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 题目的提示matrix 是存在的
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (row - 1 >= 0 && col - 1 >= 0 && matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
