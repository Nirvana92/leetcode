package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/19 21:39
 * <p>
 * 1140. 石子游戏 II
 */
public class No_1140_Stone_Game_II {
    @Test
    public void test() {
        int[] piles = new int[]{2, 7, 9, 4, 4};

        piles = new int[]{4, 3, 2, 34, 21, 7, 9, 4, 4, 343, 4, 1111, 324, 2, 4536, 546, 7765, 76, 432, 5, 47, 90};

        int stoneGameII = stoneGameII(piles);
        System.out.println(stoneGameII);

        int stoneGameIIDp = stoneGameIIDp(piles);
        System.out.println(stoneGameIIDp);
    }

    public int stoneGameII(int[] piles) {
        int m = 1;

        int first = first(piles, 0, m);
        return first;
    }

    public int stoneGameIIDp(int[] piles) {
        int N = piles.length;
        if (N <= 1) {
            return N == 0 ? 0 : piles[0];
        }
        int[][] first = new int[N][N];
        int[][] last = new int[N][N];

        for (int i = N - 1; i >= 0; i--) {
            // m 从大到小
            for (int m = N - 1; m > 0; m--) {
                // 填充 first 的数组
                int maxIndex = 2 * m + i;
                if (maxIndex >= piles.length) {
                    int sum = 0;
                    for (int index = i; index < piles.length; index++) {
                        sum += piles[index];
                    }

                    // 填充first 数组
                    first[i][m] = sum;
                    // 填充last 数组
                    // last[i][m] = 0;
                } else {
                    int maxVals = 0;
                    int preSumVals = 0;
                    int minVals = Integer.MAX_VALUE;
                    for (int index = i; index < maxIndex; index++) {
                        preSumVals += piles[index];
                        int max = Math.max(index - i + 1, m);
                        maxVals = Math.max(maxVals, preSumVals + last[index + 1][max]);
                        minVals = Math.min(minVals, first[index + 1][max]);
                    }

                    // 填充first 数组
                    first[i][m] = maxVals;
                    last[i][m] = minVals;
                }
            }
        }

        return first[0][1];
    }

    /**
     * 先手
     *
     * @param piles
     * @param i
     * @param m
     * @return
     */
    int first(int[] piles, int i, int m) {
        int maxIndex = 2 * m + i;

        if (maxIndex >= piles.length) {
            int sum = 0;
            for (int index = i; index < piles.length; index++) {
                sum += piles[index];
            }

            return sum;
        }

        int maxVals = 0;
        int preSumVals = 0;
        for (int index = i; index < maxIndex; index++) {
            preSumVals += piles[index];
            int max = Math.max(index - i + 1, m);
            maxVals = Math.max(maxVals, preSumVals + last(piles, index + 1, max));
        }

        return maxVals;
    }

    /**
     * 后手
     *
     * @param piles
     * @param i
     * @param m
     * @return
     */
    int last(int[] piles, int i, int m) {
        int maxIndex = 2 * m + i;
        if (maxIndex >= piles.length) {
            return 0;
        }

        int minVals = Integer.MAX_VALUE;
        for (int index = i; index < maxIndex; index++) {
            int max = Math.max(index - i + 1, m);
            minVals = Math.min(minVals, first(piles, index + 1, max));
        }

        return minVals;
    }
}
