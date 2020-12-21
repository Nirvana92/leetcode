package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/20 23:41
 * <p>
 * 1510. 石子游戏 IV
 */
public class No_1510_Stone_Game_IV {
    @Test
    public void test() {
        int n = 3;
        boolean winnerSquareGame = winnerSquareGame(n);
        System.out.println(winnerSquareGame);
    }

    public boolean winnerSquareGame(int n) {
        if (n <= 2) {
            return n == 1 ? true : false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        dp[2] = false;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
