package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/16 8:37 下午
 * @desc: 764. 最大加号标志
 * <p>
 * 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1 的最大的轴对齐
 * 加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
 * <p>
 * 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
 * 下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
 * <p>
 */
public class No_764_Maximum_plus_sign {
    @Test
    public void test() {
        int N = 5;
        int[][] mines = new int[][]{{}};

        N = 10;
        mines = new int[][]{
                {4, 6}
        };

        N = 2;
        mines = new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        N = 2;
        mines = new int[][]{
                {0, 0},
                {1, 1}
        };
        int orderOfLargestPlusSign = orderOfLargestPlusSign(N, mines);
        System.out.println(orderOfLargestPlusSign);
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // 通过使用辅助数组的方式计算每个点 i, j 到上下左右能延长的最大值
        if (N == 0) {
            return 0;
        }
        if (mines.length == 0 || mines[0].length == 0) {
            return (N + 1) / 2;
        }
        // 初始化0的点
        // Map<Integer, Integer> minesMaps = new HashMap<>();
        boolean[][] minesMaps = new boolean[N][N];
        for (int i = 0; i < mines.length; i++) {
            minesMaps[mines[i][0]][mines[i][1]] = true;
        }

        int[][] upLens = new int[N][N];
        int[][] downLens = new int[N][N];
        int[][] leftLens = new int[N][N];
        int[][] rightLens = new int[N][N];

//        upLens[0][0] = minesMaps[0][0] ? 0 : 1;
//        leftLens[0][0] = upLens[0][0];
        for (int i = 0; i < N; i++) {
            // 填充up
            upLens[0][i] = minesMaps[0][i] ? 0 : 1;
            upLens[i][0] = minesMaps[i][0] ? 0 : 1;
            upLens[i][N - 1] = minesMaps[i][N - 1] ? 0 : 1;
            upLens[N - 1][i] = minesMaps[N - 1][i] ? 0 : 1;
            // 填充left
            leftLens[0][i] = upLens[0][i];
            leftLens[i][0] = upLens[i][0];
            leftLens[i][N - 1] = upLens[i][N - 1];
            leftLens[N - 1][i] = upLens[N - 1][i];

            // 填充 down
            downLens[0][i] = upLens[0][i];
            downLens[i][0] = upLens[i][0];
            downLens[i][N - 1] = upLens[i][N - 1];
            downLens[N - 1][i] = upLens[N - 1][i];
            // 填充 right
            rightLens[0][i] = upLens[0][i];
            rightLens[i][0] = upLens[i][0];
            rightLens[i][N - 1] = upLens[i][N - 1];
            rightLens[N - 1][i] = upLens[N - 1][i];
        }

        // 填充up, left 普遍位置
        for (int row = 1; row < N; row++) {
            for (int col = 1; col < N; col++) {
                upLens[row][col] = minesMaps[row][col] ? 0 : 1 + upLens[row - 1][col];
                leftLens[row][col] = minesMaps[row][col] ? 0 : 1 + leftLens[row][col - 1];
            }
        }

        // 填充down, right 普遍位置
        for (int row = N - 2; row >= 0; row--) {
            for (int col = N - 2; col >= 0; col--) {
                downLens[row][col] = minesMaps[row][col] ? 0 : 1 + downLens[row + 1][col];
                rightLens[row][col] = minesMaps[row][col] ? 0 : 1 + rightLens[row][col + 1];
            }
        }

        // 遍历每个位置, 求最大的长度
        int maxLen = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int tmpLen = Math.min(Math.min(upLens[row][col], downLens[row][col]), Math.min(leftLens[row][col], rightLens[row][col]));
                maxLen = Math.max(maxLen, tmpLen);
            }
        }

        return maxLen;
    }
}
