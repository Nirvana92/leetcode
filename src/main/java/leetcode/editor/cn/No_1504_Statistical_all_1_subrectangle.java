package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/18 20:36
 * 1504. 统计全 1 子矩形
 * <p>
 * 可以使用单调栈求解
 */
public class No_1504_Statistical_all_1_subrectangle {
    @Test
    public void test() {
        int[][] mat = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        mat = new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        };

        mat = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        int numSubmat = numSubmat(mat);
        System.out.println(numSubmat);
    }

    /**
     * 求以每个点作为右下角点组成的矩形的个数
     *
     * @param mat
     * @return
     */
    public int numSubmat(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int rowLen = mat.length;
        int colLen = mat[0].length;

        int[][] countOfNums = new int[rowLen][colLen];

        // 初始化计数数组
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (col == 0) {
                    countOfNums[row][col] = mat[row][col];
                } else if (mat[row][col] == 1) {
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
                    rst += curColLen;
                }
            }
        }

        return rst;
    }
}
