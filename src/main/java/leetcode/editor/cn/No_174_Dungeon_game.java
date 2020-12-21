package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/21 3:48 下午
 * @desc: 174. 地下城游戏
 */
public class No_174_Dungeon_game {
    @Test
    public void test() {
        int[][] dungeon = new int[][]{
                {-2, -3, 3, -1},
                {-5, -10, -1, -4},
                {10, -30, -5, 3},
                {-7, 10, -7, 3}
        };
        int calculateMinimumHP = calculateMinimumHP(dungeon);
        System.out.println(calculateMinimumHP);

        int calculateMinimumHPDp = calculateMinimumHPDp(dungeon);
        System.out.println(calculateMinimumHPDp);
    }

    /**
     * 改写dp 的方法
     *
     * @param dungeon
     * @return
     */
    int calculateMinimumHPDp(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;

        int[][] dp = new int[rowLen][colLen];
        dp[rowLen - 1][colLen - 1] = dungeon[rowLen - 1][colLen - 1] < 0 ? Math.abs(dungeon[rowLen - 1][colLen - 1]) + 1 : 1;

        for (int row = rowLen - 2; row >= 0; row--) {
            dp[row][colLen - 1] = dungeon[row][colLen - 1] >= dp[row + 1][colLen - 1] ? 1 : dp[row + 1][colLen - 1] - dungeon[row][colLen - 1];
        }

        for (int col = colLen - 2; col >= 0; col--) {
            dp[rowLen - 1][col] = dungeon[rowLen - 1][col] >= dp[rowLen - 1][col + 1] ? 1 : dp[rowLen - 1][col + 1] - dungeon[rowLen - 1][col];
        }

        for (int row = rowLen - 2; row >= 0; row--) {
            for (int col = colLen - 2; col >= 0; col--) {
                // 往右走
                int rightNextNeedHP = dp[row][col + 1];
                int p1 = dungeon[row][col] >= rightNextNeedHP ? 1 : rightNextNeedHP - dungeon[row][col];

                // 往下走
                int downNextNeedHP = dp[row + 1][col];
                int p2 = dungeon[row][col] >= downNextNeedHP ? 1 : downNextNeedHP - dungeon[row][col];

                dp[row][col] = Math.min(p1, p2);
            }
        }

        return dp[0][0];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;

        if (rowLen == 0 || colLen == 0) {
            return 0;
        }

        return process(dungeon, 0, 0);
    }

    int process(int[][] dungeon, int row, int col) {
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;

        if (row == rowLen - 1 && col == colLen - 1) {
            return dungeon[row][col] < 0 ? Math.abs(dungeon[row][col]) + 1 : 1;
        }

        int minHP = Integer.MAX_VALUE;
        // 往右走
        if (col + 1 < colLen) {
            int nextNeedHP = process(dungeon, row, col + 1);
            int p1 = dungeon[row][col] >= nextNeedHP ? 1 : nextNeedHP - dungeon[row][col];
            minHP = Math.min(minHP, p1);
        }

        // 往下走
        if (row + 1 < rowLen) {
            int nextNeedHP = process(dungeon, row + 1, col);
            int p2 = dungeon[row][col] >= nextNeedHP ? 1 : nextNeedHP - dungeon[row][col];
            minHP = Math.min(minHP, p2);
        }

        return minHP;
    }
}
