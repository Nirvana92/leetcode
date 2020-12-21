package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/19 21:54
 */
public class No_1277_Count_square_sub_matrices_with_all_ones {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        matrix = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        int countSquares = countSquares(matrix);
        System.out.println(countSquares);
    }

    public int countSquares(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[][] countOfNums = new int[rowLen][colLen];

        // 初始化计数数组
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (col == 0) {
                    countOfNums[row][col] = matrix[row][col];
                } else if (matrix[row][col] == 1) {
                    countOfNums[row][col] = countOfNums[row][col - 1] + 1;
                } else {
                    countOfNums[row][col] = 0;
                }
            }
        }

        // 求最终的个数
        int rst = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                // 以最短的一个长度为限度值
                int curColLen = countOfNums[row][col];
                // 当前节点依次往上找, 取连续的最小值统计到结果集中
                for (int rowDiff = 0; rowDiff <= row && countOfNums[row - rowDiff][col] != 0; rowDiff++) {
                    curColLen = Math.min(curColLen, countOfNums[row - rowDiff][col]);
                    if (curColLen >= rowDiff + 1) {
                        rst++;
                    }
//                     rst += curColLen;
                }
            }
        }

        return rst;
    }
}
