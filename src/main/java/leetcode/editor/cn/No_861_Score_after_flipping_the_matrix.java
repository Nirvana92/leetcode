package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/7 10:49 上午
 * @desc: 861. 翻转矩阵后的得分
 */
public class No_861_Score_after_flipping_the_matrix {
    @Test
    public void test() {
        int[][] a = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};

        int matrixScore = matrixScore(a);
        System.out.println(matrixScore);
    }

    public int matrixScore(int[][] A) {
        int rowLen = A.length;
        int colLen = A[0].length;

        // 首先判断每行的第一位是否是 1 , 不是 1 进行翻转, 否则不动
        for (int row = 0; row < rowLen; row++) {
            if (A[row][0] != 1) {
                // 需要翻转
                flipRow(A, row);
            }
        }

        // 然后遍历每列, 如果0 的数量 > 1 的数量, 翻转
        for (int col = 0; col < colLen; col++) {
            int numOfZeros = 0;
            for (int row = 0; row < rowLen; row++) {
                if (A[row][col] == 0) {
                    numOfZeros++;
                }
            }

            if (numOfZeros > (rowLen - numOfZeros)) {
                // 翻转
                flipCol(A, col);
            }
        }

        // 统计最后的结果值
        int ret = 0;
        for (int row = 0; row < rowLen; row++) {
            int tmpVal = 0;
            int bitVal = 1;
            for (int col = colLen - 1; col >= 0; col--) {
                tmpVal += bitVal * A[row][col];

                bitVal *= 2;
            }

            ret += tmpVal;
        }

        return ret;
    }

    void flipRow(int[][] a, int row) {
        int colLen = a[0].length;

        for (int col = 0; col < colLen; col++) {
            a[row][col] = a[row][col] ^ 1;
        }
    }

    void flipCol(int[][] a, int col) {
        int rowLen = a.length;

        for (int row = 0; row < rowLen; row++) {
            a[row][col] = a[row][col] ^ 1;
        }
    }
}
