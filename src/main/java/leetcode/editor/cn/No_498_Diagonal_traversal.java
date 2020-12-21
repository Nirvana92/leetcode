package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/23 3:37 下午
 * @desc: 498. 对角线遍历
 * <p>
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * 示例:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class No_498_Diagonal_traversal {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[] diagonalOrder = findDiagonalOrder(matrix);
        PrintUtils.print(diagonalOrder);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] traversal = new int[rowLen * colLen];

        boolean toLeftDown = false;
        int row = 0, col = 0, traversalIndex = 0;
        while (row < rowLen && col < colLen) {
            if (toLeftDown) {
                // 遍历的方向是往左下角找数据
                while (row < rowLen && col >= 0) {
                    traversal[traversalIndex++] = matrix[row][col];
                    row++;
                    col--;
                }
                row--;
                col++;
                // 遍历完成, row, col 往下或右移动
                if (row < rowLen - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                // 遍历的方向是往右上角找数
                while (row >= 0 && col < colLen) {
                    traversal[traversalIndex++] = matrix[row][col];
                    row--;
                    col++;
                }
                row++;
                col--;
                // 遍历完成, row, col 往右或下移动
                if (col < colLen - 1) {
                    col++;
                } else {
                    row++;
                }
            }

            toLeftDown = !toLeftDown;
        }

        return traversal;
    }

//    int process(int[][] matrix, int row, int col, boolean toLeftDown, int index, int[] traversal) {
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//
//        if (toLeftDown) {
//            // 遍历的方向是往左下角找数据
//            while (row < rowLen && col >= 0) {
//                traversal[index++] = matrix[row][col];
//
//                row++;
//                col--;
//            }
//        } else {
//            // 遍历的方向是往右上角找数
//            while (row >= 0 && col < colLen) {
//                traversal[index++] = matrix[row][col];
//
//                row--;
//                col++;
//            }
//        }
//    }
}
