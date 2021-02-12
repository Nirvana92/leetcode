package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2021/1/19 4:02 下午
 * @desc: 1727. 重新排列后的最大子矩阵
 */
public class No_1727_The_largest_submatrix_after_rearrangement {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};

        int largestSubmatrix = largestSubmatrix(matrix);
        System.out.println(largestSubmatrix);
    }

    public int largestSubmatrix(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[][] assistMatrix = new int[rowLen][colLen];

        // 初始化辅助数组
        for (int col = 0; col < colLen; col++) {
            for (int row = rowLen - 1; row >= 0; row--) {
                if (matrix[row][col] == 1) {
                    assistMatrix[row][col] = (row == rowLen - 1) ? matrix[row][col] : matrix[row][col] + assistMatrix[row + 1][col];
                }
            }
        }

        // 遍历求每一行的结果
        int largest = 0;
        for (int i = 0; i < rowLen; i++) {
            int[] tmp = assistMatrix[i];
            Arrays.sort(tmp);

            int minHeight = tmp[tmp.length - 1];
            for (int j = tmp.length - 1; j >= 0; j--) {
                if (tmp[j] == 0) {
                    break;
                }

                minHeight = Math.min(minHeight, tmp[j]);
                largest = Math.max((tmp.length - j) * minHeight, largest);
            }
        }

        return largest;
    }
}
