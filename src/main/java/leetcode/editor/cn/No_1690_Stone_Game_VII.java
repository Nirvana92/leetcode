package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/18 10:34 上午
 * @desc: 1690. 石子游戏 VII
 */
public class No_1690_Stone_Game_VII {
    @Test
    public void test() {
        int[] stones = new int[]{5, 3, 1, 4, 2};
        stones = new int[]{7, 90, 5, 1, 100, 10, 10, 2};

        int stoneGameVII = stoneGameVII(stones);
        System.out.println(stoneGameVII);

        int stoneGameVIIDp = stoneGameVIIDp(stones);
        System.out.println(stoneGameVIIDp);
    }

    /**
     * dp 的处理方法
     *
     * @param stones
     * @return
     */
    public int stoneGameVIIDp(int[] stones) {
        int N = stones.length;

        int[] ltors = new int[N];
        for (int i = 0; i < N; i++) {
            ltors[i] = stones[i] + (i == 0 ? 0 : ltors[i - 1]);
        }

        int[][] firstDp = new int[N][N], lastDp = new int[N][N];

        /**
         * 初始化两个元素的时候的结果填充到dp中
         */
        for (int i = 0; i < N - 1; i++) {
            // 选择l 的时候的得分 [l+1, r]
            int lScores = stones[i + 1];

            // 选择r 的时候的得分
            int rScores = stones[i];

            firstDp[i][i + 1] = Math.max(lScores, rScores);
            lastDp[i][i + 1] = Math.min(-lScores, -rScores);
        }

        for (int l = N - 1; l >= 0; l--) {
            for (int r = l + 2; r < N; r++) {
                // 选择l 的时候的得分 [l+1, r]
                int lScores = ltors[r] - ltors[l];

                // 选择r 的时候的得分
                int rScores = ltors[r - 1] - (l == 0 ? 0 : ltors[l - 1]);

                firstDp[l][r] = Math.max(lastDp[l + 1][r] + lScores, +lastDp[l][r - 1] + rScores);
                lastDp[l][r] = Math.min(firstDp[l + 1][r] - lScores, firstDp[l][r - 1] - rScores);
            }
        }

        return firstDp[0][N - 1];
    }


    public int stoneGameVII(int[] stones) {
        int[] ltors = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            ltors[i] = stones[i] + (i == 0 ? 0 : ltors[i - 1]);
        }

        return first(stones, 0, stones.length - 1, ltors);
    }

    /**
     * 先手: 尽可能拉开差距
     *
     * @param stones
     * @param l
     * @param r
     * @return: 差值[firstScore - lastScore]
     */
    int first(int[] stones, int l, int r, int[] ltors) {
        if (l == r) {
            return 0;
        }

        // 选择l 的时候的得分 [l+1, r]
        int lScores = ltors[r] - ltors[l];

        // 选择r 的时候的得分
        int rScores = ltors[r - 1] - (l == 0 ? 0 : ltors[l - 1]);

        return Math.max(lScores + last(stones, l + 1, r, ltors), rScores + last(stones, l, r - 1, ltors));
    }

    /**
     * 后手: 尽可能的减少差距
     *
     * @param stones
     * @param l
     * @param r
     * @return: 差值[firstScore - lastScore]
     */
    int last(int[] stones, int l, int r, int[] ltors) {
        if (l == r) {
            return 0;
        }

        // 选择l 的时候的得分 [l+1, r]
        int lScores = ltors[r] - ltors[l];

        // 选择r 的时候的得分
        int rScores = ltors[r - 1] - (l == 0 ? 0 : ltors[l - 1]);

        return Math.min(first(stones, l + 1, r, ltors) - lScores, first(stones, l, r - 1, ltors) - rScores);
    }
}
