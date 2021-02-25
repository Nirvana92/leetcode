package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author Nirvana
 * @date 2021/2/17 22:19
 * <p>
 * 566. 重塑矩阵
 */
public class No_566_Reshape_matrix {
    @Test
    public void test() {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        int r = 1, c = 4;
        r = 2;
        c = 4;

        int[][] matrixReshape = matrixReshape(nums, r, c);
        PrintUtils.print(matrixReshape);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // 首先判断是否满足要求
        int rowLen = nums.length;
        int colLen = nums[0].length;

        if (rowLen * colLen != r * c) {
            return nums;
        }

        int[][] newMatrixs = new int[r][c];
        // 往后移动的行列下标
        int rIndex = 0, cIndex = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cIndex >= colLen) {
                    cIndex = 0;
                    rIndex++;
                }

                newMatrixs[i][j] = nums[rIndex][cIndex];
                cIndex++;
            }
        }

        return newMatrixs;
    }
}
