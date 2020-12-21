package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/19 22:59
 * <p>
 * 877. 石子游戏
 */
public class No_877_Stone_game {
    @Test
    public void test() {
        int[] p = new int[]{5, 10000, 5};

        p = new int[]{3216, 6546, 43, 13, 131, 654, 64, 341, 654, 61, 3, 13, 13, 1, 654, 64, 31, 31, 6, 16, 1, 313, 1};

        boolean stoneGame = stoneGame(p);

        System.out.println(first(p, 0, p.length - 1) > last(p, 0, p.length - 1));

        System.out.println(stoneGame);
    }

    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        if (N < 2) {
            return false;
        }
        int[][] first = new int[N][N];
        int[][] last = new int[N][N];

        for (int i = 0; i < N; i++) {
            first[i][i] = piles[i];
        }

        // r
        for (int i = 1; i < N; i++) {
            // l
            int l = 0, r = i;
            while (l < N && r < N) {
                first[l][r] = Math.max(last[l + 1][r] + piles[l], last[l][r - 1] + piles[r]);
                last[l][r] = Math.min(first[l + 1][r], first[l][r - 1]);
                l++;
                r++;
            }
        }

        return first[0][N - 1] > last[0][N - 1];
    }

    int first(int[] piles, int l, int r) {
        if (l == r) {
            return piles[l];
        }

        return Math.max(last(piles, l + 1, r) + piles[l], last(piles, l, r - 1) + piles[r]);
    }

    int last(int[] piles, int l, int r) {
        if (l == r) {
            return 0;
        }

        return Math.min(first(piles, l + 1, r), first(piles, l, r - 1));
    }
}
